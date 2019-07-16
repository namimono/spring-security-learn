package com.namimono.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@Slf4j
public class AsynController {

    @GetMapping("/asynHello")
    public Callable<String> rasynHello(){

        log.info("主线程开始");
        Callable<String> result=new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("副线程开始");
                Thread.sleep(1000);
                log.info("副线程结束");

                return "success";
            }
        };
        log.info("主线程结束");

        return result;
    }
}
