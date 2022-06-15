package com.example.patientinformationservice.exceptions;

import static java.lang.String.*;

public class PatientRecordNotFoundException extends Exception{

    private String message;

    public PatientRecordNotFoundException(String message){

        super(format(message));
        this.message = message;

    }
}
