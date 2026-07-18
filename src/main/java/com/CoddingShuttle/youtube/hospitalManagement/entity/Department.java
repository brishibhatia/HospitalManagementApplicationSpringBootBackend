package com.CoddingShuttle.youtube.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true , nullable = false)
    private String name;


    @OneToOne
    private Doctor headDoctor;
    @ManyToMany(mappedBy = "doctors")
    private Set<Doctor> doctors = new HashSet<>();
}
