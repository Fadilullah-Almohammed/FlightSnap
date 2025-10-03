package com.swe.flightsnap.apimanagement.flightsearch;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private Meta meta;
    private ArrayList<Datum> data;
    private Dictionaries dictionaries;

    // Getters and Setters
    public Meta getMeta() { return meta; }
    public void setMeta(Meta meta) { this.meta = meta; }
    public ArrayList<Datum> getData() { return data; }
    public void setData(ArrayList<Datum> data) { this.data = data; }
    public Dictionaries getDictionaries() { return dictionaries; }
    public void setDictionaries(Dictionaries dictionaries) { this.dictionaries = dictionaries; }
}