package com.krooj.controllers;

import com.krooj.messages.ShoutOut;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by krooj on 8/16/15.
 */
@RestController
public class ShoutOutController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "/shoutout", method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseEntity<Void> shoutOut(@RequestBody ShoutOut shoutOut) {
        amqpTemplate.convertAndSend(shoutOut);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
