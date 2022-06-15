package com.example.patientinformationservice.service.serviceImpl;

import com.example.patientinformationservice.dto.PatientDto;
import com.example.patientinformationservice.dto.VisitsDto;
import com.example.patientinformationservice.entity.Patient;
import com.example.patientinformationservice.entity.Visits;
import com.example.patientinformationservice.exceptions.PatientRecordNotFoundException;
import com.example.patientinformationservice.exceptions.NoVisitationRecordFoundException;
import com.example.patientinformationservice.repository.PatientRepository;
import com.example.patientinformationservice.repository.VisitRepository;
import com.example.patientinformationservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.example.patientinformationservice.utils.PatientUtilitiesClass.encryptor;
import static com.example.patientinformationservice.utils.PatientUtilitiesClass.patientAge;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final VisitRepository visitRepository;

    @Override
    public ResponseEntity<String> createPatient(PatientDto patientDto) {
        Patient patient = Patient.builder()
                .firstName(patientDto.getFirstName())
                .lastName(patientDto.getLastName())
                .dob(LocalDate.from(patientDto.getDob()))
                .age(patientAge(LocalDate.from(patientDto.getDob())))
                .email(patientDto.getEmail())
                .registeredDate(LocalDate.now())
                .build();
        patientRepository.save(patient);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Patient "+patient.getFirstName()+" has been registered successfully");
    }

    @Cacheable(cacheNames = "patient",key="#patientId")
    @Override
    public ResponseEntity<Patient> getPatient(Long patientId) throws PatientRecordNotFoundException {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow( ()-> new PatientRecordNotFoundException("Patient not found"));
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }

    @Override
    public ResponseEntity<List<Patient>> getPatientsByAgeRange(int startRange, int endRange) throws PatientRecordNotFoundException {
        List<Patient> patients = patientRepository.findByAgeBetween(startRange,endRange);
        if (patients == null) {
            throw new PatientRecordNotFoundException("No patient found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(patients);
    }

    @Override
    public ResponseEntity<String> createPatientVisit( VisitsDto visitsDto) throws PatientRecordNotFoundException {

        Patient patient = patientRepository.findById(visitsDto.getPatientId())
                .orElseThrow(()-> new PatientRecordNotFoundException("patient not found"));
        Visits visit = Visits.builder()
       .visitDate(LocalDate.now())
       .healthCondition(encryptor(visitsDto.getHealthCondition()))
       .doctorOnDuty(visitsDto.getDoctorOnDuty())
       .prescription(encryptor(visitsDto.getPrescription()))
       .patient(patient)
       .build();

        visitRepository.save(visit);

        return ResponseEntity.status(HttpStatus.CREATED).body("Visit Registered");
    }


    @Cacheable(cacheNames = "patient",key = "#id")
    @Override
    public ResponseEntity<Visits> viewPatientVisits(Long id) throws NoVisitationRecordFoundException {

        Optional<Patient> patient = patientRepository.findById(id);
        Visits visits = visitRepository.findVisitsByPatient_PatientId(patient);
        if (visits == null) {
            throw new NoVisitationRecordFoundException("there are no visits yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(visits);
    }


}
