package com.namimono.browser.config.LoginValidate.sms;

import com.namimono.browser.config.LoginValidate.ValidateCode;
import com.namimono.browser.config.LoginValidate.ValidateCodeGenerator;
import com.namimono.browser.properties.LoginProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SmsCodeGenerator implements ValidateCodeGenerator {

    private Random random=new Random();
    @Autowired
    private LoginProperties loginProperties;

    @Override
    public ValidateCode generateCode() {
        int codeSize=loginProperties.getCodeSize();
        int livetime=loginProperties.getLivetime();
        String code = String.valueOf(random.nextInt((int)Math.pow(10,4)));
//        String code = RandomStringUtils.randomNumeric(codeSize);
//
//        new SmsValidateCode(codeSize,livetime);
        return new SmsValidateCode(code,livetime);
    }
}
