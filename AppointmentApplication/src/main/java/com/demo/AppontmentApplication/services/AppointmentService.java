package com.demo.AppontmentApplication.services;

import org.springframework.stereotype.Service;
import com.demo.AppontmentApplication.entities.Appointment;

@Service
public interface AppointmentService {
	
	public Appointment appointmentBooking(int pid,int did, String dateTime, String reason);

}
