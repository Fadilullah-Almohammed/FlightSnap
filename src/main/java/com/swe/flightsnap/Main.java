package com.swe.flightsnap;

import com.swe.flightsnap.apimanagement.flightsearch.*;

import java.io.IOException;
import java.time.LocalDate;

import com.swe.flightsnap.apimanagement.*;
import com.swe.flightsnap.apimanagement.Exceptions.ApiException;

public class Main {
    public static void main(String[] args) {

        APIFlightSearch apiSearch = new APIFlightSearch();

        try {
            Root data = apiSearch.searchFlights("SYD", "BKK", LocalDate.of(2025, 10, 6), 1);
     
            String a = data.getData().get(0).getPrice().getGrandTotal();
            String b = data.getData().get(0).getPrice().getCurrency();

            System.out.println(a + " : " + b);
     
        }
        catch (ApiException | IOException | InterruptedException apiException) {
            apiException.printStackTrace();
        }



        
    }
}
