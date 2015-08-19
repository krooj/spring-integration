package com.krooj.transformers;

import com.krooj.messages.ShoutOut;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

/**
 * Created by krooj on 8/17/15.
 */
@Component
public class LineItemMessageTransformer {

    @Transformer
    public ShoutOut createShoutOut(String messageLine) {
        return ShoutOut.messageLine2ShoutOut(messageLine);
    }

}
