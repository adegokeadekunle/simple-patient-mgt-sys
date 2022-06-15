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
public class Visits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long VisitId;
    private LocalDate visitDate;
    private String healthCondition;
    private String doctorOnDuty;
    private String prescription;
    @ManyToOne
    private Patient patient;

}
