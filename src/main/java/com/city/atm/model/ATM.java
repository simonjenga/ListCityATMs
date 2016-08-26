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

    /**
     * Public default constructor
     */
    public ATM() {
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return this.address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the distance
     */
    public Long getDistance() {
        return this.distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(Long distance) {
        this.distance = distance;
    }

    /**
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
}
