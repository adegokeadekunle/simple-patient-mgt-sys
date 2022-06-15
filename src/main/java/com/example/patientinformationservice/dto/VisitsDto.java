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
public class VisitsDto {

    private Long patientId;
    private LocalDate visitDate;
    private String healthCondition;
    private String doctorOnDuty;
    private String prescription;
}
