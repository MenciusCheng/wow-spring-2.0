package com.marvel.demo.controller;

import com.marvel.demo.domain.Greeting;
import com.marvel.demo.property.DatabaseProperty;
import com.marvel.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Marvel on 18/09/12.
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private final DatabaseProperty databaseProperty;
    private final UserService userService;

    @Autowired
    public GreetingController(DatabaseProperty databaseProperty, UserService userService) {
        this.databaseProperty = databaseProperty;
        this.userService = userService;
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/greeting2")
    public Greeting greeting2(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), databaseProperty.getUrl());
    }

    @RequestMapping("/helloUser")
    public Greeting helloUser(@RequestParam(value = "name", defaultValue = "World") String name) {
        userService.printUser(name);
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
