package com.CoddingShuttle.youtube.hospitalManagement.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 50)
    private String specialisation;

    @Column(unique = true, nullable = false)
    private String email;


//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "appointments")
//    private List<Appointment> appointments;

}
