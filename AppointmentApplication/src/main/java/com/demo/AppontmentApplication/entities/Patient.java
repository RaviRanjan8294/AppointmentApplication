package com.demo.AppontmentApplication.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Patient {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String phoneNo;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private double age;
	
	
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@ManyToMany//(cascade = {CascadeType.PERSIST},fetch=FetchType.EAGER)
	private List<Doctor> doctor;
	
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Appointment> appontment;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(int id, String firstName, String lastName, String phoneNo, Gender gender, List<Doctor> doctor,
			List<Appointment> appontment) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.doctor = doctor;
		this.appontment = appontment;
	}
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
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo=" + phoneNo
				+ ", gender=" + gender + ", doctor=" + doctor + ", appontment=" + appontment + "]";
	}
	public void addDoctor(Doctor d)
	{
		if(doctor == null) {
			doctor = new ArrayList<>();
		}
		doctor.add(d);
	}
	

}
