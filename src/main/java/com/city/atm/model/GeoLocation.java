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

    /**
     * Public default constructor
     */
    public GeoLocation() {
    }

    /**
     * @return the lat
     */
    public String getLat() {
        return this.lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * @return the lng
     */
    public String getLng() {
        return this.lng;
    }

    /**
     * @param lng the lng to set
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "GeoLocation{" + "lat='" + this.lat + '\'' + ", lng=" + this.lng + '}';
    }
}
