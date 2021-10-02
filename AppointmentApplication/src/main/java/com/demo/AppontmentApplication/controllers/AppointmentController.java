package com.demo.AppontmentApplication.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.demo.AppontmentApplication.entities.Appointment;
import com.demo.AppontmentApplication.exception.FieldErrorMessage;
import com.demo.AppontmentApplication.services.AppointmentService;


@RestController
@RequestMapping("/api")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/appointmentBook/{patientId}/{doctorId}/{dateTime}/{reason}")
	@ResponseStatus(code = HttpStatus.OK)
	public Appointment saveAppointment(@PathVariable("patientId") int pid,@PathVariable("doctorId") int did,
			@PathVariable("dateTime") String date,@PathVariable("reason") String reason) {
		
		return appointmentService.appointmentBooking(pid, did, date, reason);
		
		
		
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public List<FieldErrorMessage> handleValidationExpcetion(MethodArgumentNotValidException ex) {
		
		List<FieldError> errorList = ex.getBindingResult().getFieldErrors();
		
		List<FieldErrorMessage> list = new ArrayList<>();
		
		for(FieldError error : errorList ) {
			FieldErrorMessage frm = new FieldErrorMessage(error.getField(), error.getDefaultMessage());
			list.add(frm);
		}
		
		
		return list;
	
	

	}
}
