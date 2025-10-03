package com.swe.flightsnap.apimanagement.flightsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@JsonIgnoreProperties(ignoreUnknown = true)
public class Meta {
    private int count;
    private Links links;

    // Getters and Setters
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }
    public Links getLinks() { return links; }
    public void setLinks(Links links) { this.links = links; }
}

