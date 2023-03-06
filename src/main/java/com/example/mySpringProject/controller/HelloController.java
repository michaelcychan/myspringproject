package com.example.mySpringProject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

import java.util.concurrent.atomic.AtomicInteger;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.example.mySpringProject.model.HelloModel;

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

    private final AtomicInteger counter = new AtomicInteger();
    // @GetMapping() empty because of the class has a mapping
    @GetMapping()
    public ResponseEntity<HelloModel> helloWorld() {
        HelloModel response = new HelloModel(counter.incrementAndGet(), "Hello World! Number of calls has been incremented:" + counter.get());
        return ResponseEntity.status(200).body(response);
    }

    /*
    by using HelloModel, it can respond with a JSON format. The body now is a JSON with HelloModel format.
     */

    @GetMapping("/oh-no")
    public ResponseEntity<HelloModel> noHelloWorld() {
        HelloModel response = new HelloModel(counter.decrementAndGet(), "No hello world! Number of calls has been decreased: " + counter.get());
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping(path="/make-query")
    @ResponseStatus(code=HttpStatus.OK, reason= "OK")
    public ResponseEntity<String> echoParams(@RequestParam(value = "yearOfBirth") String yearOfBirth, @RequestParam(value="name") String name) {
        String query = "SELECT * FROM people WHERE year_of_birth = \"" +yearOfBirth + "\" AND name = \"" + name +"\";";
        return ResponseEntity.status(200).body(query);
    }

    // this extra mapping makes sub-domain of /hello => /hello/{name}
    @GetMapping("/{name}")
    public String helloName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/multiply-by-two/{input}")
    public ResponseEntity<String> testGetError(@PathVariable String input) {
        try {
            int num = Integer.parseInt(input);
            String output = input + " times 2 equals " + Integer.toString(num * 2);
            return ResponseEntity.status(HttpStatus.OK).body(output);
        } catch (Exception  e) {
            String errorRes =  "Input is not an integer";
            return ResponseEntity.status(BAD_REQUEST).body((errorRes));
        }
    }

    @PostMapping("/test-error")
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "You shall not pass")
    public void testPostError() {

    }

}
