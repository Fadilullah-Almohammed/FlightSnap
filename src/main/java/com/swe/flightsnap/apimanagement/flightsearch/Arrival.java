package com.swe.flightsnap.apimanagement.flightsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Arrival {
    private String iataCode;
    private String at;

    // Getters and Setters
    public String getIataCode() { return iataCode; }
    public void setIataCode(String iataCode) { this.iataCode = iataCode; }
    public String getAt() { return at; }
    public void setAt(String at) { this.at = at; }
}