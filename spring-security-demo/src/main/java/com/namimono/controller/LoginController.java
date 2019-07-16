package com.namimono.controller;

import com.namimono.browser.config.LoginValidate.sms.SmsCodeProcessor;
import com.namimono.service.MyUserDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(tags = "用户管理")
@RestController
@RequestMapping("auth")
@Slf4j
public class LoginController {

    @Autowired
    private SmsCodeProcessor smsCodeProcessor;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @ApiOperation(value = "用户登录",notes = "用户登录")
    @PostMapping("/login")
    public String login(String username,String password){
      log.info("login contoller");
      log.info("username"+username+"password:"+ password);
//      myUserDetailsService.loadUserByUsername(username);
        return "";
    }

    @ApiOperation(value = "短信登陆",notes = "短信登陆")
    @GetMapping("/login/sms")
    public String smsLogin(HttpServletRequest request, HttpServletResponse response, @RequestParam String mobile){
        smsCodeProcessor.create(new ServletWebRequest(request,response));

        return "success";
    }
}
