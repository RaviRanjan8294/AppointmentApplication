package com.demo.AppontmentApplication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.AppontmentApplication.entities.Patient;
import com.demo.AppontmentApplication.repositories.PatientRepository;


@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepo;
	
	public Patient save(Patient patient) {
		return patientRepo.save(patient);
	}
	
	public List<Patient> getPatient(){
		return patientRepo.findAll();
	}
	
	public Patient getPatient(int id)
	{
		return patientRepo.getById(id);
	}
	
public Patient updatePatient(int id, Patient pat) {
		
		Optional<Patient> optEmp = patientRepo.findById(id);
		
		if(optEmp.isPresent()) {
			Patient p = optEmp.get();
			p.setFirstName(pat.getFirstName());
			p.setLastName(pat.getLastName());
			p.setPhoneNo(pat.getPhoneNo());
			p.setAge(pat.getAge());
			p.setGender(pat.getGender());
			patientRepo.save(p);
			return p;
		}
		
		return null;
	}

}
