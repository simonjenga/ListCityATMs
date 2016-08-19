package com.city.atm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This is a Domain class that will contain the data (latitude and longitude) representation
 * for the Geographical Location (GeoLocation) object
 * 
 * @author Simon Njenga
 * @since 0.1
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoLocation {

    private String lat;

    private String lng;

}
