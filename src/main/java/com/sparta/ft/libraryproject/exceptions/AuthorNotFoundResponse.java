package com.sparta.ft.libraryproject.exceptions;

public class AuthorNotFoundResponse {

    private String response;
    private int statusCode;

    public AuthorNotFoundResponse(String response, int statusCode) {
        this.response = response;
        this.statusCode = statusCode;
    }

    public String getResponse() {
        return response;
    }

    public int getStatusCode() {
        return statusCode;
    }

}
