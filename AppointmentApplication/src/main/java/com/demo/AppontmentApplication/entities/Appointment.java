package com.demo.AppontmentApplication.entities;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Appointment {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String appointmentDateTime;
	private String reason;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	private Patient patient;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Doctor doctor;
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(int id, String appointmentDateTime, String reason ) {
		super();
		this.id = id;
		this.appointmentDateTime = appointmentDateTime;
		this.reason = reason;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAppointmentDateTime() {
		return appointmentDateTime;
	}
	public void setAppointmentDateTime(String appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
}
