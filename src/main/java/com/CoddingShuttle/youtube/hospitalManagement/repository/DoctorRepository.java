package com.CoddingShuttle.youtube.hospitalManagement.repository;

import com.CoddingShuttle.youtube.hospitalManagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}