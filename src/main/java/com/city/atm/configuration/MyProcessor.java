package com.city.atm.configuration;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

/**
 * Class description to be done later!
 *
 * @author Simon Njenga
 * @since 0.1
 */
public class MyProcessor {

    public void process(Exchange exchange) {
        System.out.println("process");
        Message in = exchange.getIn();
        byte[] file = in.getBody(byte[].class);
        System.out.println("bytes found:" + file.length);
    }

}
