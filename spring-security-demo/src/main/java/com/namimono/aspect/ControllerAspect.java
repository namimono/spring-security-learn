package com.namimono.aspect;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
//@Component
@Slf4j
public class ControllerAspect {

    //    表示Pointcut为所有标了@RestController注解的方法
    @Pointcut("execution(* com.namimono.controller.*.*(..))")
    public void pointcut() {

    }

    @Around("execution(* com.namimono.controller.*.*(..))")
    public Object assertAround(ProceedingJoinPoint pjp) throws Throwable {

        Class<?> aClass = pjp.getTarget().getClass(); //先获取被织入增强处理的目标对象，再获取目标类的class
        String methodName = pjp.getSignature().getName(); //先获取目标方法的签名，再获取目标方法的名
        log.info("执行类为:"+aClass+" 调用的方法为:"+methodName);
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            log.info("传入参数为" + arg);

        }
        Object proceed = pjp.proceed();
        return proceed;
    }
}
