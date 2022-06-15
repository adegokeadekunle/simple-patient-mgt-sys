package com.example.patientinformationservice.service;

import com.example.patientinformationservice.dto.PatientDto;
import com.example.patientinformationservice.dto.VisitsDto;
import com.example.patientinformationservice.entity.Patient;
import com.example.patientinformationservice.entity.Visits;
import com.example.patientinformationservice.exceptions.PatientRecordNotFoundException;
import com.example.patientinformationservice.exceptions.NoVisitationRecordFoundException;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface PatientService {
    ResponseEntity<String> createPatient(PatientDto patientDto);
    ResponseEntity<Patient> getPatient(Long patientId) throws PatientRecordNotFoundException;
    ResponseEntity<List<Patient>> getPatientsByAgeRange(int startAge, int endAge) throws PatientRecordNotFoundException;
    ResponseEntity<String> createPatientVisit(VisitsDto visitsDto) throws PatientRecordNotFoundException;
    ResponseEntity<Visits> viewPatientVisits(Long patientId) throws NoVisitationRecordFoundException;

}
