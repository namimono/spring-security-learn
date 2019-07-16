package com.namimono.browser.config.LoginValidate;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

@Component
public interface ValidateProcessor {
    public void create(ServletWebRequest webRequest);
}
