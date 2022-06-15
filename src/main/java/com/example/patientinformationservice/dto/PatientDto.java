package com.example.patientinformationservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String email;


}
