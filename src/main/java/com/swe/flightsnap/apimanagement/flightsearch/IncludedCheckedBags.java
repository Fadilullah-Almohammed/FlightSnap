package com.swe.flightsnap.apimanagement.flightsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class IncludedCheckedBags {
    private int weight;
    private String weightUnit;
    private int quantity;

    // Getters and Setters
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
    public String getWeightUnit() { return weightUnit; }
    public void setWeightUnit(String weightUnit) { this.weightUnit = weightUnit; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
