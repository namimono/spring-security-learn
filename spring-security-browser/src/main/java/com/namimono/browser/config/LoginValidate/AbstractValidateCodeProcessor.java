package com.namimono.browser.config.LoginValidate;

import org.springframework.web.context.request.ServletWebRequest;

public abstract class AbstractValidateCodeProcessor implements ValidateProcessor {
    protected int a=1;

    public void create(ServletWebRequest webRequest){
        ValidateCode validateCode = generateCode();
        save(validateCode,webRequest);
        send(validateCode,webRequest);
    }
    protected abstract ValidateCode generateCode();
    protected abstract void send(ValidateCode validateCode,ServletWebRequest webRequest);
    protected abstract void save(ValidateCode validateCode,ServletWebRequest webRequest);
}
