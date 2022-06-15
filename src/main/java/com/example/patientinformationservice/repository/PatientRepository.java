package com.example.patientinformationservice.repository;

import com.example.patientinformationservice.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByAgeBetween(int startRange,int endRange);

}
