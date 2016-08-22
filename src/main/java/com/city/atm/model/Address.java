package com.city.atm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This is a Domain class that will contain the data representation for the Address object
 * 
 * @author Simon Njenga
 * @since 0.1
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    private String street;

    private String housenumber;

    private String postalcode;

    private String city;

    private GeoLocation geoLocation;

}
