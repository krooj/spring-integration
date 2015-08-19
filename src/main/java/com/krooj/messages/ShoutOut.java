package com.krooj.messages;

import java.util.*;

/**
 * Created by krooj on 8/17/15.
 */
public class ShoutOut {

    public enum Destination{
        TWITTER,
        STDOUT
    }

    private String sender;

    private String recipient;

    private String message;

    private Destination destination;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public static ShoutOut messageLine2ShoutOut(String messageLine){
        StringTokenizer stringTokenizer = new StringTokenizer(messageLine,",");
        Map<String, String> objectMap = new TreeMap<>();
        while (stringTokenizer.hasMoreTokens()){
            String currentToken = stringTokenizer.nextToken();
            ListIterator<String> tokenPartIterator = Arrays.asList(currentToken.split("=")).listIterator();
            String key = tokenPartIterator.next();
            String value = tokenPartIterator.next();
            objectMap.put(key, value);
        }
        ShoutOut shoutOut = new ShoutOut();
        for(String key: objectMap.keySet()){
            switch (key){
                case "sender":
                    shoutOut.setSender(objectMap.get(key));
                    break;
                case "recipient":
                    shoutOut.setRecipient(objectMap.get(key));
                    break;
                case "message":
                    shoutOut.setMessage(objectMap.get(key));
                    break;
                case "destination":
                    shoutOut.setDestination(Destination.valueOf(objectMap.get(key)));
                default:
                    break;
            }
        }
        return shoutOut;
    }

    @Override
    public String toString() {
        return "ShoutOut{" +
                "sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", message='" + message + '\'' +
                ", destination=" + destination +
                '}';
    }
}
