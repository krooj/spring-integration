package com.krooj.services;

import com.krooj.messages.ShoutOut;

/**
 * Created by krooj on 8/18/15.
 */
public interface IShoutOutService {
    void handle(ShoutOut payload);
}
