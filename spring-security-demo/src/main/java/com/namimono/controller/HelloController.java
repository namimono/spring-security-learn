package com.namimono.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){

        return "hello";
    }

    @GetMapping("/hello/{id}")
    public String hello2(@PathVariable String id){

        return "hello";
    }
}
