package com.demo.AppontmentApplication.services;


import java.awt.Color;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.AppontmentApplication.entities.Appointment;
import com.demo.AppontmentApplication.entities.Doctor;
import com.demo.AppontmentApplication.entities.Patient;
import com.demo.AppontmentApplication.entities.Status;
import com.demo.AppontmentApplication.repositories.AppointmentRepository;
import com.demo.AppontmentApplication.repositories.DoctorRepository;
import com.demo.AppontmentApplication.repositories.PatientRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	
	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private DoctorRepository doctorRepo;
	
	public Appointment appointmentBooking(int pid,int did,String dateTime,String reason) {
		
		Optional<Patient> optpat = patientRepo.findById(pid);
		Patient petient = optpat.get();
		
		Optional<Doctor> optdoc = doctorRepo.findById(did);
		Doctor doctor = optdoc.get();
		
		Appointment appt = new Appointment();
      	if(doctor.isFree() == true)
		{
			
			appt.setPatient(petient);
			appt.setDoctor(doctor);
			appt.setAppointmentDateTime(dateTime);
			appt.setReason(reason);
			appt.setStatus(Status.Confirmed);
			appointmentRepo.save(appt);
			
			System.out.println("Appointment Confirmed Successfully...");
			
			
			return appt;
		}
		else
		{
		
			System.out.println("Appointment failed... Check with Other Doctor..");
			appt.setAppointmentDateTime("Not Available");
			appt.setReason(reason);
			appt.setStatus(Status.NotConfirmed);
		}
    	
		return appt;
		
	}

}
