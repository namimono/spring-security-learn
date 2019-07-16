package com.namimono.browser.config.LoginValidate.sms;

import com.namimono.browser.config.LoginValidate.AbstractValidateCodeProcessor;
import com.namimono.browser.config.LoginValidate.ValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

@Component("smsCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor {
    @Autowired
    private SmsCodeGenerator SmsCodeGenerator;
    @Override
    protected ValidateCode generateCode() {
        ValidateCode validateCode = SmsCodeGenerator.generateCode();
        return validateCode;
    }

    @Override
    protected void send(ValidateCode validateCode, ServletWebRequest webRequest) {
//        webRequest.getRequest();
        System.out.println("smsProcessor send");

    }

    @Override
    protected void save(ValidateCode validateCode, ServletWebRequest webRequest) {
        System.out.println("smsProcessor save");
//        HttpServletRequest httpServletRequest = (HttpServletRequest) webRequest.getNativeRequest();
//        httpServletRequest.getSession().setAttribute("SmsCode",validateCode);

    }
}
