package com.seamfix.nin.model;

public enum  RequestStatus {

    UNSUCCESSFUL("UNSUCCESSFUL"),
    SUCCESSFUL("SUCCESSFUL");

    private String description;

    RequestStatus(String description){ this.description = description;}


}
