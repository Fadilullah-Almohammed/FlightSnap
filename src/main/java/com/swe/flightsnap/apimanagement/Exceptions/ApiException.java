package com.swe.flightsnap.apimanagement.Exceptions;

public class ApiException extends Exception {
    
    private final int statusCode;
    private final String responseBody;

    public ApiException(String message, int statusCode, String responseBody) {

        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }
    

    @Override
    public String getMessage() {
        return super.getMessage() + "(Status code: " + this.getStatusCode() + ", Body: " + this.responseBody + ")";
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getResponseBody() {
        return this.responseBody;
    }

}
