package com.example.mySpringProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

/*
* the @ symbol corresponds to the annotation.
* The @GetMapping and @RestController are examples of Annotations.
* Annotations are built-in units of Spring that are readily available.
* @GetMapping will be run every time it receives a request to the endpoint
 */

// RequestMapping can be used for the whole controller or individual methods
@RestController
@RequestMapping("/hello")
public class HelloController {
    // @GetMapping() empty because of the class has a mapping
    @GetMapping()
    public String helloWorld() {
        return "Hello world!";
    }

    // this extra mapping makes sub-domain of /hello => /hello/{name}
    @GetMapping("/{name}")
    public String helloName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
}
