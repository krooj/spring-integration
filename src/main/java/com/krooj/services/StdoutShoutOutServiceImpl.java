package com.krooj.services;

import com.krooj.messages.ShoutOut;
import org.springframework.stereotype.Service;

/**
 * Created by Michael on 8/18/15.
 */
@Service("stdoutShoutOutServiceImpl")
public class StdoutShoutOutServiceImpl implements ShoutOutService{

    @Override
    public void handle(ShoutOut payload) {
        System.out.println(payload);
    }
}
