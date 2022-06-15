package com.example.patientinformationservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(NoVisitationRecordFoundException.class)
    public ResponseEntity<ErrorHandler> resolveVisitationRecordNotFoundException(
            NoVisitationRecordFoundException visitationRecordNotFoundException,
            WebRequest webRequest){
        ErrorHandler errorsInfo = new ErrorHandler(new Date(),visitationRecordNotFoundException.getMessage(),webRequest.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorsInfo);
    }

    @ExceptionHandler(PatientRecordNotFoundException.class)
    public ResponseEntity<ErrorHandler> resolvePatientNotFoundException(
            PatientRecordNotFoundException patientNotFoundException,
            WebRequest webRequest){
        ErrorHandler errorsInfo = new ErrorHandler(new Date(),patientNotFoundException.getMessage(),webRequest.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorsInfo);
    }

}