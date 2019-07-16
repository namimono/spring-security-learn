package com.namimono.bean;

import com.namimono.browser.config.LoginValidate.ValidateProcessor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class Test2 {

    @Autowired
    private Map<String, ValidateProcessor> validateCodeProcessors;

    @Test
    public void test(){
        ValidateProcessor smsCodeProccessor = validateCodeProcessors.get("smsCodeProcessor");
    }



}