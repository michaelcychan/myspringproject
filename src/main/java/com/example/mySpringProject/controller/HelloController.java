package com.example.mySpringProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// the @ symbol corresponds to the annotation.
// The @GetMapping and @RestController are examples of Annotations.
@RestController
public class HelloController {
    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello world!";
    }
}
