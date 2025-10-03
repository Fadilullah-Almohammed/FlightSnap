package com.swe.flightsnap.apimanagement.flightsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Segment {
    private String id;
    private Departure departure;
    private Arrival arrival;
    private String carrierCode;
    private String duration;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Departure getDeparture() { return departure; }
    public void setDeparture(Departure departure) { this.departure = departure; }
    public Arrival getArrival() { return arrival; }
    public void setArrival(Arrival arrival) { this.arrival = arrival; }
    public String getCarrierCode() { return carrierCode; }
    public void setCarrierCode(String carrierCode) { this.carrierCode = carrierCode; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
}