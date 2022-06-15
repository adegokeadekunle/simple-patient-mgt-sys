package com.example.patientinformationservice.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Base64;

public class PatientUtilitiesClass {
    public static int patientAge(LocalDate dob){
        LocalDate today = LocalDate.now();
        return Period.between(dob,today).getYears();
    }

    public static String encryptor(String message){
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(message.getBytes());
    }

    public static String decryptor(String message){
        Base64.Decoder decoder = Base64.getUrlDecoder();
        return new String(decoder.decode(message));
    }


}
