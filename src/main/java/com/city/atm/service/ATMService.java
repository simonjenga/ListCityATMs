package com.city.atm.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.city.atm.component.ATMComponent;
import com.city.atm.model.ATM;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class ATMService {

    @Autowired
    private ATMComponent atmComponent;

    public List<ATM> listATMs() throws JsonParseException,
            JsonMappingException, IOException {
        return this.atmComponent.listATMs();
    }

    public List<ATM> listATMsByCity(String city) throws JsonParseException,
            JsonMappingException, IOException {
        return this.atmComponent.listATMsByCity(city);
    }

}
