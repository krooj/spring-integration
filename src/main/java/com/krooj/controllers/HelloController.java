package com.krooj.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by krooj on 8/16/15.
 */
@RestController
public class HelloController {

    @Value("${test.test}")
    private String response;

    @RequestMapping(value = "hello", method = RequestMethod.GET, produces = {"application/json"})
    public String sayHello() {
        return response;
    }

}
