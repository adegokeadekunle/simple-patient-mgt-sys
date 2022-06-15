package com.example.patientinformationservice.controller;

import com.example.patientinformationservice.dto.PatientDto;
import com.example.patientinformationservice.dto.VisitsDto;
import com.example.patientinformationservice.entity.Patient;
import com.example.patientinformationservice.entity.Visits;
import com.example.patientinformationservice.exceptions.PatientRecordNotFoundException;
import com.example.patientinformationservice.exceptions.NoVisitationRecordFoundException;
import com.example.patientinformationservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/create-patient")
    public ResponseEntity<String> createPatient(@RequestBody PatientDto patientDto){
        return patientService.createPatient(patientDto);
    }

    @GetMapping("/get-patient/{patientId}")
    public ResponseEntity<Patient> patientDetail(@PathVariable(value = "patientId") Long patientId) throws PatientRecordNotFoundException {
        return patientService.getPatient(patientId);

    }

    @GetMapping("/patient-by-age-range")
    public ResponseEntity<List<Patient>> patientByAgeRange(@RequestParam(value = "startAge")int startAge,
                                                           @RequestParam(value = "endAge")int endAge) throws PatientRecordNotFoundException {
        return patientService.getPatientsByAgeRange(startAge,endAge);
    }

    @PostMapping("/create-patient-visit")
    public ResponseEntity<String> createPatientVisit(@RequestBody VisitsDto visitsDto) throws PatientRecordNotFoundException {
        return patientService.createPatientVisit(visitsDto);
    }

    @GetMapping("/patient-visit/{id}")
    public ResponseEntity<Visits> patientVisits(@PathVariable("id") Long id) throws NoVisitationRecordFoundException {
        return patientService.viewPatientVisits(id);
    }
}
