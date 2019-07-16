package com.namimono.browser.config;

import com.namimono.browser.properties.LoginProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableConfigurationProperties(LoginProperties.class)
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
//    只要容器中有PasswordEncoder，每次UserDetailsService.loadUserByUsername()登陆的时候都会调用PasswordEncoder.matches()方法将密码解析。
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginProcessingUrl("/auth/login")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.getWriter().write("success");

                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

                        response.getWriter().write("fail ");
                    }
                })
                .and()
                .csrf().disable()
                .authorizeRequests()
//                .anyRequest()
//                .authenticated()

//                必须放行所有静态资源，否则swagger无法正常访问
                .antMatchers(
                        HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/authUser/login").permitAll()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/static/**").permitAll()  //过滤 允许
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/api-docs/**").permitAll()
//                除了上述请求，拦截所有请求
                .anyRequest().fullyAuthenticated();


    }
}
