package com.namimono.browser.config.LoginValidate.sms;

import com.namimono.browser.config.LoginValidate.AbstractValidateCodeProcessor;
import com.namimono.browser.config.LoginValidate.ValidateCode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

@Component
public class TestProcessor extends AbstractValidateCodeProcessor {
    @Override
    protected ValidateCode generateCode() {
        return null;
    }

    @Override
    protected void send(ValidateCode validateCode, ServletWebRequest webRequest) {
        System.out.println("send");
    }

    @Override
    protected void save(ValidateCode validateCode, ServletWebRequest webRequest) {

    }
}
