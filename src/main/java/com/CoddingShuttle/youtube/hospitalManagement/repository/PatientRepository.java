package com.CoddingShuttle.youtube.hospitalManagement.repository;

import com.CoddingShuttle.youtube.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;



@Repository
public interface PatientRepository extends JpaRepository<Patient,Long > {
    Patient findByName(String name);

    Patient findByNameOrEmail(String name, String email);
}
