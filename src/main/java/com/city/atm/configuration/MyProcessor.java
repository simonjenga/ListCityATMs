package com.city.atm.configuration;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

/**
 * This class uses an Apache Camel Processor {@link org.apache.camel.Processor} to adjust or
 * change a message from the processor.
 *
 * Please visit here for more details: 
 * http://camel.apache.org/using-getin-or-getout-methods-on-exchange.html
 
 * A processor is used to implement the <b>Event Driven Consumer</b> and <b>Message Translator</b> patterns
 * and to process message exchanges.
 *
 * http://camel.apache.org/event-driven-consumer.html
 * http://camel.apache.org/message-translator.html
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
