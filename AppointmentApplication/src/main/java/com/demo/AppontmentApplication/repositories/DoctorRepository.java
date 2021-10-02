package com.demo.AppontmentApplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.AppontmentApplication.entities.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
	
	List<Doctor> getDoctorBySpeciality(String speciality);

}
