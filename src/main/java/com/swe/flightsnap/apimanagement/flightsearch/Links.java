package com.swe.flightsnap.apimanagement.flightsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Links {
    private String self;

    // Getters and Setters
    public String getSelf() { return self; }
    public void setSelf(String self) { this.self = self; }
}
