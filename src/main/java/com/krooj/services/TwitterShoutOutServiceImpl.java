package com.krooj.services;

import com.krooj.messages.ShoutOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * Created by krooj on 8/18/15.
 */
@Service("twitterShoutOutService")
public class TwitterShoutOutServiceImpl implements ShoutOutService {

    Logger LOGGER = LoggerFactory.getLogger(TwitterShoutOutServiceImpl.class);

    private Twitter twitter;

    @Autowired
    public TwitterShoutOutServiceImpl(Twitter twitter) {
        this.twitter = twitter;
    }

    public void handle(ShoutOut payload){
        LOGGER.info("op=handle {}", payload);
        try{
            twitter.updateStatus("@"+payload.getRecipient()+" - "+payload.getMessage());
        }catch (TwitterException e){
            LOGGER.error("op=handle",e);
        }
    }

    public void handle(byte[] payload){
        LOGGER.info("op=handle {}", payload);
    }

}
