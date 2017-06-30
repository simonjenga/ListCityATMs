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
 * Apache Camel offers a Java based Domain Specific Language (DSL) using the fluent builder style.
 *
 * The Java DSL is made available by extending the <code>RouteBuilder</code> class, and implementing
 * the {@link #configure()} method. In our subclass here, we extend the <code>RouteBuilder</code> class
 * and then override it's {@link #configure()} method where we define our routing rules.
 *
 * @author Simon Njenga
 * @since 0.1
 */
@Component(value = "atmComponent")
public class ATMComponent extends RouteBuilder {


    /** This is the URL for the external service API */
    private static final String URL = "https://www.ing.nl/api/locator/atms/";

    /**
     * Retrieves a list of all <code>ATM</code> objects from the <code>ATMComponent</code> class.
     * @throws JsonParseException If there is an error parsing the JSON response or the response is not a valid JSON
     * @throws JsonMappingException If there is a problem in accessing a suitable serializer or deserializer
     * @throws IOException If there are some any other problems inside
     * @return a <code>List</code> of <code>ATM</code> objects
     */
    public List<ATM> listATMs() throws JsonParseException,
            JsonMappingException, IOException {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(URL, String.class);
        String toBeParsed = response.substring(6, response.length());

        ObjectMapper objectMapper = new ObjectMapper();
        ATM[] atms = objectMapper.readValue(toBeParsed, ATM[].class);

        return Arrays.asList(atms);
    }

    /**
     * Retrieves a list of all <code>ATM</code> objects from the <code>ATMComponent</code> class.
     * @param city the city name to perform a look up of atm's machines
     * @throws JsonParseException If there is an error parsing the JSON response or the response is not a valid JSON
     * @throws JsonMappingException If there is a problem in accessing a suitable serializer or deserializer
     * @throws IOException If there are some any other problems inside
     * @return a <code>List</code> of <code>ATM</code> objects
     */
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
