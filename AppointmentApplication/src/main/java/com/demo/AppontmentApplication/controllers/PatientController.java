package com.demo.AppontmentApplication.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.AppontmentApplication.entities.Patient;
import com.demo.AppontmentApplication.exception.FieldErrorMessage;
import com.demo.AppontmentApplication.services.PatientService;




@RestController
@RequestMapping("/api")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/patients")
	public List<Patient> getPatient(){
		return patientService.getPatient();	
	}
	
	@GetMapping("/patients/{patientId}")
	public Patient getPatient(@PathVariable("patientId") int id){
		return patientService.getPatient(id);
	}
	
	@PutMapping("/patients/{patientId}")
	public Patient update(@PathVariable("patientId") int id, @RequestBody Patient pat) {
		return patientService.updatePatient(id, pat);
	}
	
	@PostMapping("/patients")
	@ResponseStatus(code = HttpStatus.OK)
	public Patient savePatient(@RequestBody Patient pat) {
		
		return patientService.save(pat);
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
