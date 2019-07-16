package com.namimono.browser.config.LoginValidate.sms;

import com.namimono.browser.config.LoginValidate.ValidateCode;

import java.time.LocalDateTime;

public class SmsValidateCode extends ValidateCode {


    private LocalDateTime deadLine;

    public SmsValidateCode(String code,int livetime) {
        super(code);
        //设定Smscode存在期限
        this.deadLine=LocalDateTime.now().plusSe短信登陆开发conds(livetime);
    }

    public boolean isDead(){

        return LocalDateTime.now().isAfter(deadLine);
    }

}
