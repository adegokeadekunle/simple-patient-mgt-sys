package com.example.patientinformationservice.repository;

import com.example.patientinformationservice.entity.Patient;
import com.example.patientinformationservice.entity.Visits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VisitRepository extends JpaRepository<Visits , Long> {

    Visits findVisitsByPatient_PatientId(Optional<Patient> visitId);
}
