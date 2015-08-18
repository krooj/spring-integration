package com.krooj.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by krooj on 8/16/15.
 */
@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUncaughtExceptions(Throwable t){
        return new ResponseEntity<String>(t.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
