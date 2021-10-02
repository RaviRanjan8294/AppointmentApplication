package com.demo.AppontmentApplication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.AppontmentApplication.entities.Doctor;
import com.demo.AppontmentApplication.repositories.DoctorRepository;


@Service
public class DoctorService {

	
	@Autowired
	private DoctorRepository doctorRepo;
	
	public Doctor save(Doctor doctor)
	{
		return doctorRepo.save(doctor);
	}
	
	public List<Doctor> getAllDoctor()
	{
		return doctorRepo.findAll();
	}
	
	public Doctor getDoctorById(int id)
	{
		return doctorRepo.findById(id).get();
	}
	
	
	public List<Doctor> getDoctorBySpeciality(String speciality)
	{
		return doctorRepo.getDoctorBySpeciality(speciality);
	}
	
	public Doctor updateDoctor(int id,Doctor doc)
	{
		Optional<Doctor> opt = doctorRepo.findById(id);
		if(opt.isPresent()) {
			Doctor d = opt.get();
			d.setFirstName(doc.getFirstName());
			d.setLastName(doc.getLastName());
			d.setSpeciality(doc.getSpeciality());
			d.setFree(doc.isFree());
			doctorRepo.save(d);
			return d;
		}
		
		return null;
	}
}
