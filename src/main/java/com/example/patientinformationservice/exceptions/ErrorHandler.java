package com.example.patientinformationservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ErrorHandler {
    private Date timestamp;
    private String message;
    private String details;
}
