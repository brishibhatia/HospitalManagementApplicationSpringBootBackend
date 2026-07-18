package com.CoddingShuttle.youtube.hospitalManagement.entity;

import com.CoddingShuttle.youtube.hospitalManagement.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
        name = "patient",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = {"name","birthDate"})
        },
        indexes = {
                @Index(name = "idx_patient_email", columnList = "email")
        }

)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @ToString.Exclude
    private LocalDate birthDate;

    @Column(nullable = false, unique = true)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @JoinColumn(name = "patient_insurance_id")      //owning side
    @OneToOne(cascade = CascadeType.ALL)
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

}
