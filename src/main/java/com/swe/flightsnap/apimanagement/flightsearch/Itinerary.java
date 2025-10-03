package com.swe.flightsnap.apimanagement.flightsearch;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Itinerary {
    private String duration;
    private ArrayList<Segment> segments;
    
    // Getters and Setters
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    public ArrayList<Segment> getSegments() { return segments; }
    public void setSegments(ArrayList<Segment> segments) { this.segments = segments; }
}