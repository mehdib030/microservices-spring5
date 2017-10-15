package com.example.demo.controller;

import com.example.demo.bean.WelcomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mehdi on 10/14/2017.
 */
@RestController
public class BasicController {

    private static final String helloWorldTemplate="Hello World, %s!";

    @GetMapping("/welcome")
    public String welcome(){
        return "Hello World";
    }
    @GetMapping("/welcome-with-object")
    public WelcomeBean welcomeWithObject(){
        return new WelcomeBean("Hello World");
    }

    @GetMapping("/welcome-with-parameter/name/{name}")
    public WelcomeBean welcomeWithParameter(@PathVariable String name){
        return new WelcomeBean(String.format(helloWorldTemplate, name));
    }
}
