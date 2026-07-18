package com.CoddingShuttle.youtube.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(nullable = false)
    private String reason;

    @ManyToOne()
    @JoinColumn(name = "patient_id" , nullable = false)
    private Patient patient;

    @ManyToOne()
    @JoinColumn(nullable = false)
    private Doctor doctor;
}
