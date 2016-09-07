package com.city.atm.configuration;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

public class MyProcessor {

    public void process(Exchange exchange) {
        System.out.println("process");
        Message in = exchange.getIn();
        byte[] file = in.getBody(byte[].class);
        System.out.println("bytes found:" + file.length);
    }

}
