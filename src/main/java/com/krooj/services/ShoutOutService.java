package com.krooj.services;

import com.krooj.messages.ShoutOut;
import org.springframework.stereotype.Service;

/**
 * Created by krooj on 8/18/15.
 */
@Service
public class ShoutOutService implements IShoutOutService{

    public void handle(ShoutOut payload){
        System.out.println(payload);
    }

}
