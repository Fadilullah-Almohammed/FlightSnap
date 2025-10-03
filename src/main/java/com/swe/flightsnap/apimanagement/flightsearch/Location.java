package com.swe.flightsnap.apimanagement.flightsearch;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// This single class replaces all the individual airport classes (SYD, BKK, etc.)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    private String cityCode;
    private String countryCode;

    // Getters and Setters
    public String getCityCode() { return cityCode; }
    public void setCityCode(String cityCode) { this.cityCode = cityCode; }
    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }
}