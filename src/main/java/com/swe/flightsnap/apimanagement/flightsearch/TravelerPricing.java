package com.swe.flightsnap.apimanagement.flightsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;



@JsonIgnoreProperties(ignoreUnknown = true)
public class TravelerPricing {
    private String travelerId;
    private String travelerType;
    private Price price;
    private ArrayList<FareDetailsBySegment> fareDetailsBySegment;

    // Getters and Setters
    public String getTravelerId() { return travelerId; }
    public void setTravelerId(String travelerId) { this.travelerId = travelerId; }
    public String getTravelerType() { return travelerType; }
    public void setTravelerType(String travelerType) { this.travelerType = travelerType; }
    public Price getPrice() { return price; }
    public void setPrice(Price price) { this.price = price; }
    public ArrayList<FareDetailsBySegment> getFareDetailsBySegment() { return fareDetailsBySegment; }
    public void setFareDetailsBySegment(ArrayList<FareDetailsBySegment> fareDetailsBySegment) { this.fareDetailsBySegment = fareDetailsBySegment; }
}
