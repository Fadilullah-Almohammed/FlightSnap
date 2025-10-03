package com.swe.flightsnap.apimanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swe.flightsnap.apimanagement.Exceptions.ApiException;
import com.swe.flightsnap.apimanagement.flightsearch.*;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublisher;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;




public class APIFlightSearch {

    private final HttpClient client;
    private final ObjectMapper objectMapper;

    private static String API_KEY = System.getenv("AMADEUS_API_KEY");
    private static String API_SECRET = System.getenv("AMADEUS_API_SECRET");
    

    public APIFlightSearch() {
        this.client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();

    }


/**
 * Requests flights search API to get data for a specific flight
 * 
 * 
 * @param originLocationCode departure city. Use IATA code to identify the airport
 * @param destinationLocationCode  arrival city. Use IATA code to identify the airport
 * @param departureDate date of departure. It uses YYYY-MM-DD format.
 * @param adults number of adults
 * @return Root object containing searched flight data
 * @throws ApiException if there is a problem with API call.
 * @throws IOException if a network or I/O error occurs.
 * @throws InterruptedException if the operation is interrupted.
 */


public Root searchFlights(String originLocationCode, String destinationLocationCode, LocalDate departureDate, int adults) 
    throws ApiException, IOException, InterruptedException {
    

    try {

        // Get the access token.
        String accessToken = fetchAccessToken();

        // Build the URL.
        String baseUrl = "https://test.api.amadeus.com/v2/shopping/flight-offers";
        Map<String, String> params = new HashMap<>();
        params.put("originLocationCode", originLocationCode);
        params.put("destinationLocationCode", destinationLocationCode);
        params.put("departureDate", departureDate.toString());
        params.put("adults", String.valueOf(adults));

        StringBuilder urlBuilder = new StringBuilder(baseUrl);
        urlBuilder.append("?");

        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (!first) {
                urlBuilder.append("&");
            }

            first = false;

            urlBuilder.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            urlBuilder.append("=");
            urlBuilder.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
        }
        String fullUrl = urlBuilder.toString();

        // Build the request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fullUrl))
                .header("Authorization", "Bearer " + accessToken)
                .GET()
                .build();
        
        // Send request, check status, and deserialize all data.
        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new ApiException("Flight search request failed", response.statusCode(), response.body());
        }

        Root flightData = this.objectMapper.readValue(response.body(), Root.class);
        
        System.out.println("Successfully deserialized flight data!");

        if (flightData.getData() != null && !flightData.getData().isEmpty()) {

            return flightData;

        }
        
        System.out.println("No flight offers found for the given criteria.");

    } catch (ApiException e) {
        System.err.println("API Error: " + e.getMessage());
    } catch (IOException | InterruptedException e) {
        System.err.println("Network or system error: " + e.getMessage());
    }

    return null;
}


    /**
     * Call the Amandeus API to fetch "access_token" from received data to
     * be authorized to access flights search API.
     * 
     * It uses "API key" and "API secret" to send a request to the amandeus API endpoint.
     * 
     * @return access token string
     * @throws ApiException if the API returns a non-200 status code.
     * @throws IOException if a network or I/O error occurs.
     * @throws InterruptedException if the operation is interrupted.
     */
    public String fetchAccessToken() throws ApiException, IOException, InterruptedException {


        String baseUrl = "https://test.api.amadeus.com/v1/security/oauth2/token";


        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("grant_type", "client_credentials");
        bodyData.put("client_id", API_KEY);
        bodyData.put("client_secret", API_SECRET);


        StringBuilder bodyBuilder = new StringBuilder();

        for (Map.Entry<String, String> entry: bodyData.entrySet()) {

            if (bodyBuilder.length() > 0) {
                bodyBuilder.append("&");
            }

            bodyBuilder.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            bodyBuilder.append("=");
            bodyBuilder.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
        }

        String requestBody = bodyBuilder.toString();



        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(baseUrl))
                                .header("Content-Type", "application/x-www-form-urlencoded")
                                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                                .build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        if (response.statusCode() != 200) {
            throw new ApiException("Failed to fetch for access token", response.statusCode(), response.body());
        }

            
        try {

            AccessToken accessToken = objectMapper.readValue(response.body(), AccessToken.class);

            String token = accessToken.getAccessToken();

            return token;
        }
        catch (Exception e) {
            throw new ApiException("Failed to parse token from response body", 500, response.body());
        }
    }

    
}
