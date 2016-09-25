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

/**
 * Class description to be done later!
 *
 * @author Simon Njenga
 * @since 0.1
 */
@Component
public class ATMComponent extends RouteBuilder {

    // URL for the external service API
    private static final String URL = "https://www.ing.nl/api/locator/atms/";

    public List<ATM> listATMs() throws JsonParseException,
            JsonMappingException, IOException {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(URL, String.class);
        String toBeParsed = response.substring(6, response.length());

        ObjectMapper objectMapper = new ObjectMapper();
        ATM[] atms = objectMapper.readValue(toBeParsed, ATM[].class);

        return Arrays.asList(atms);
    }

    public List<ATM> listATMsByCity(String city) throws JsonParseException,
            JsonMappingException, IOException {
        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(URL, String.class);
        String toBeParsed = response.substring(6, response.length());

        ObjectMapper objectMapper = new ObjectMapper();
        ATM[] atms = objectMapper.readValue(toBeParsed, ATM[].class);

        List<ATM> atmsList = Arrays.asList(atms);
        List<ATM> atmsByCityList = new LinkedList<ATM>();

        for (ATM atm : atmsList) {
            String theType = atm.getType(), theCity = atm.getAddress()
                    .getCity();
            if (theType.equals("ING") && theCity.equalsIgnoreCase(city)) {
                atmsByCityList.add(atm);
            }
        }

        return atmsByCityList;
    }

    @Override
    public void configure() {
        // set up a listener on the file component
        super.from("file://target/test?noop=true").bean("myProcessor", "process");
    }
}
