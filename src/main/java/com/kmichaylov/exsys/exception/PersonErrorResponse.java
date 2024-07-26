package com.kmichaylov.exsys.exception;

/**
 * Class for declaring the structure for the Person exception class.
 */
public class PersonErrorResponse {

    private int statusCode;
    private String message;
    private long timestamp;

    public PersonErrorResponse() {

    }

    public PersonErrorResponse(int statusCode, String message, long timestamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

