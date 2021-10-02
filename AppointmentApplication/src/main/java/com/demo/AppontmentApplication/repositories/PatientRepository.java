package com.demo.AppontmentApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.AppontmentApplication.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
