package com.demo.AppontmentApplication.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Doctor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String speciality;
	private boolean free;
//	@Enumerated(EnumType.STRING)
//	private Status status;
//	
//	
//	public Status getStatus() {
//		return status;
//	}
//	public void setStatus(Status status) {
//		this.status = status;
//	}
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Appointment> appontment;
	
	@Autowired
	@ManyToMany(cascade = {CascadeType.ALL})
	private List<Patient> patient;
	
	
	public boolean isFree() {
		return free;
	}
	public void setFree(boolean free) {
		this.free = free;
	}
	
//	public List<Appointment> getAppontment() {
//		return appontment;
//	}
//	public void setAppontment(List<Appointment> appontment) {
//		this.appontment = appontment;
//	}
//	public List<Patient> getPatient() {
//		return patient;
//	}
//	public void setPatient(List<Patient> patient) {
//		this.patient = patient;
//	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", speciality=" + speciality
				+ "]";
	}
	
//	public void addPatient(Patient p) {
//		if(patient == null) {
//			patient = new ArrayList<>();
//		}
//		patient.add(p);
//	}
	

}
