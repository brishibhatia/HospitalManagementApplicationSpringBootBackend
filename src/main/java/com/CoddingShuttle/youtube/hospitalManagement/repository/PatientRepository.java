package com.CoddingShuttle.youtube.hospitalManagement.repository;

import com.CoddingShuttle.youtube.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.CoddingShuttle.youtube.hospitalManagement.entity.Patient;
import com.CoddingShuttle.youtube.hospitalManagement.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface PatientRepository extends JpaRepository<Patient,Long > {
    Patient findByName(String name);

    Patient findByNameOrEmail(String name, String email);

    List<Patient> findByNameContainingOrderByIdDesc(String name);

    @Query("select p from Patient p where p.bloodGroup = :bloodGroup")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    @Query("select new com.CoddingShuttle.youtube.hospitalManagement.dto.BloodGroupCountResponseEntity(p.bloodGroup , count(p))  from Patient p  where p.bloodGroup = :bloodGroup group by p.bloodGroup ")
    List<BloodGroupCountResponseEntity> countEachBloodGroupType(@Param("bloodGroup") BloodGroupType bloodGroup);


    @Modifying
    @Transactional
    @Query("UPDATE Patient p SET p.name  =:name where p.id = :id")
    int updateNameWithId(@Param("name") String name , @Param("id") Long id);
}
