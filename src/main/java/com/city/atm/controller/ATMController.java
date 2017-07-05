package com.city.atm.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.city.atm.model.ATM;
import com.city.atm.service.ATMService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * Class description to be done later!
 * Class description to be done later!
 * Class description to be done later!
 *
 * @author Simon Njenga
 * @since 0.1
 */
@RestController
public class ATMController {

    @Autowired
    private ATMService atmService;

    @RequestMapping(value = "/listATMs", method = RequestMethod.GET)
    public ResponseEntity<List<ATM>> listATMs() throws JsonParseException,
            JsonMappingException, IOException {

        List<ATM> atmsList = this.atmService.listATMs();

        return new ResponseEntity<List<ATM>>(atmsList, HttpStatus.OK);
    }

    @RequestMapping(value = "/listATMsByCity", method = RequestMethod.GET)
    public ResponseEntity<List<ATM>> listATMsByCity(
            @RequestParam(value = "city", required = true) String city)
            throws JsonParseException, JsonMappingException, IOException {

        List<ATM> atmsByCityList = this.atmService.listATMsByCity(city);

        return new ResponseEntity<List<ATM>>(atmsByCityList, HttpStatus.OK);
    }

}
