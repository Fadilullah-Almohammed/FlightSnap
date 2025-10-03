package com.swe.flightsnap.apimanagement.flightsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
    private String currency;
    private String grandTotal;
    private String base;

    // Getters and Setters
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public String getGrandTotal() { return grandTotal; }
    public void setGrandTotal(String grandTotal) { this.grandTotal = grandTotal; }
    public String getBase() { return base; }
    public void setBase(String base) { this.base = base; }
}
