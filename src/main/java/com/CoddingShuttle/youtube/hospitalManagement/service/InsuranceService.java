package com.CoddingShuttle.youtube.hospitalManagement.service;

import com.CoddingShuttle.youtube.hospitalManagement.entity.Insurance;
import com.CoddingShuttle.youtube.hospitalManagement.entity.Patient;
import com.CoddingShuttle.youtube.hospitalManagement.repository.InsuranceRepository;
import com.CoddingShuttle.youtube.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;


    @Transactional
    public Patient assignInsuranceToPatient( Insurance insurance , Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));
        patient.setInsurance(insurance);

        System.out.println( patient);
        return patient;
    }
}
