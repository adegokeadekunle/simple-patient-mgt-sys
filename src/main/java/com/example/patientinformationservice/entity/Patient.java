package com.example.patientinformationservice.entity;


import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long patientId;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private int age;
    private String email;
    private LocalDate registeredDate;
}
