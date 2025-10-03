package com.swe.flightsnap.apimanagement.flightsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Datum {
    private String id;
    private String type;
    private Price price;
    private ArrayList<Itinerary> itineraries;
    private ArrayList<TravelerPricing> travelerPricings;
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Price getPrice() { return price; }
    public void setPrice(Price price) { this.price = price; }
    public ArrayList<Itinerary> getItineraries() { return itineraries; }
    public void setItineraries(ArrayList<Itinerary> itineraries) { this.itineraries = itineraries; }
    public ArrayList<TravelerPricing> getTravelerPricings() { return travelerPricings; }
    public void setTravelerPricings(ArrayList<TravelerPricing> travelerPricings) { this.travelerPricings = travelerPricings; }
}