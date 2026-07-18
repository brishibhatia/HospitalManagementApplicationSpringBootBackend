package com.CoddingShuttle.youtube.hospitalManagement;

import com.CoddingShuttle.youtube.hospitalManagement.entity.Insurance;
import com.CoddingShuttle.youtube.hospitalManagement.entity.Patient;
import com.CoddingShuttle.youtube.hospitalManagement.service.InsuranceService;
import com.CoddingShuttle.youtube.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testInsurance() {
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030 , 3 , 3) )
                .build();

        com.CoddingShuttle.youtube.hospitalManagement.entity.Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(insurance);


    }
}
