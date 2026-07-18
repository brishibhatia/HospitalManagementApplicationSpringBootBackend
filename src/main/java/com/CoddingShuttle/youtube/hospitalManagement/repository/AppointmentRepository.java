package com.CoddingShuttle.youtube.hospitalManagement.repository;

import com.CoddingShuttle.youtube.hospitalManagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}