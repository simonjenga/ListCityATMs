package com.city.atm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This is a Domain class that will contain the data representation for the ATM object
 * 
 * @author Simon Njenga
 * @since 0.1
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ATM {

    private Address address;

    private Long distance;

    private String type;

}
