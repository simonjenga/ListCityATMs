package com.city.atm.component;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.camel.builder.RouteBuilder;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.city.atm.model.ATM;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ATMComponent extends RouteBuilder {

    @Override
     public void configure() {
        // set up a listener on the file component
        super.from("file://target/test?noop=true").bean("myProcessor", "process");
    }
}
