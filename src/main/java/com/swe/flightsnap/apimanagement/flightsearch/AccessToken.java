package com.swe.flightsnap.apimanagement.flightsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessToken {


    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private int tokenExpire;


    public String getAccessToken() {
        return this.accessToken;
    }

    public int getTokenExpire() {
        return this.tokenExpire;
    }
}
