package com.example.patientinformationservice.exceptions;

import static java.lang.String.format;

public class NoVisitationRecordFoundException extends Exception{
    private String message;

    public NoVisitationRecordFoundException(String message){

        super(format(message));
        this.message = message;

    }
}
