package com.CoddingShuttle.youtube.hospitalManagement;

import com.CoddingShuttle.youtube.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.CoddingShuttle.youtube.hospitalManagement.entity.Patient;
import com.CoddingShuttle.youtube.hospitalManagement.repository.PatientRepository;
import com.CoddingShuttle.youtube.hospitalManagement.type.BloodGroupType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
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
        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1900 , 2 , 2));
        for( Patient patient : patientList){

        System.out.println(patient);
        }
    }
    @Test
    public void testTransactionMethod3(){
//        List<Object[]> patientList = patientRepository.countEachBloodGroupType(BloodGroupType.O_POSITIVE);
//        for( Object[] row : patientList){
//
//
//            System.out.println(row[0] +" :    " +row[1]);
//        }
        List<BloodGroupCountResponseEntity> BloodGroupResponse = patientRepository.countEachBloodGroupType(BloodGroupType.O_POSITIVE);
        System.out.println(BloodGroupResponse);

//        int rowsUpdated = patientRepository.updateNameWithId("Vasudeva Krishn" , 1L);
    }





}
