package com.demo.AppontmentApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.AppontmentApplication.entities.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

}
