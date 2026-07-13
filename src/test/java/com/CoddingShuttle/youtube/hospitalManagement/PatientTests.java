package com.CoddingShuttle.youtube.hospitalManagement;

import com.CoddingShuttle.youtube.hospitalManagement.entity.Patient;
import com.CoddingShuttle.youtube.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatientRepository(){
        List<Patient> patients= patientRepository.findAll();
        System.out.println(patients);
    }

    @Test
    public void testTransactionMethod(){
        Patient patient = patientRepository.findByName("Diya Patel");
        System.out.println(patient);
    }

    @Test
    public void testTransactionMethod2(){
        Patient patient = patientRepository.findByNameOrEmail("Diya Patel", "diya.patel@example.com");
        System.out.println(patient);
    }


}
