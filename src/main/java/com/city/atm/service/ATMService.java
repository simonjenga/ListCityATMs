package com.city.atm.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.city.atm.component.ATMComponent;
import com.city.atm.model.ATM;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * Service implementation class that provides a service for listing <code>ATM</code> machines.
 *
 * @author Simon Njenga
 * @since 0.1
 */
@Service
public class ATMService {

    @Autowired
    private ATMComponent atmComponent;

    /**
     * Retrieves a list of all <code>ATM</code> objects from the <code>ATMComponent</code> class.
     * @throws JsonParseException If there is an error parsing the JSON response or the response is not a valid JSON
     * @throws JsonMappingException If there is a problem in accessing suitable deserializer; including that of not finding any serializer
     * @throws IOException If there are some any other problems inside
     * @return a <code>List</code> of <code>ATM</code> objects
     */
    public List<ATM> listATMs() throws JsonParseException,
            JsonMappingException, IOException {
        return this.atmComponent.listATMs();
    }

    /**
     * Retrieves a list of all <code>ATM</code> objects from the <code>ATMComponent</code> class.
     * @param city the city name to perform a look up of atm's machines
     * @throws JsonParseException If there is an error parsing the JSON response or the response is not a valid JSON
     * @throws JsonMappingException If there is a problem in accessing suitable deserializer; including that of not finding any serializer
     * @throws IOException If there are some any other problems inside
     * @return a <code>List</code> of <code>ATM</code> objects
     */
    public List<ATM> listATMsByCity(String city) throws JsonParseException,
            JsonMappingException, IOException {
        return this.atmComponent.listATMsByCity(city);
    }

}
