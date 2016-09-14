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

}
