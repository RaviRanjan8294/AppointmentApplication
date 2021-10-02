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
import com.demo.AppontmentApplication.entities.Doctor;
import com.demo.AppontmentApplication.exception.FieldErrorMessage;
import com.demo.AppontmentApplication.services.DoctorService;

@RestController
@RequestMapping("/api")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctor(){
		return doctorService.getAllDoctor();	
	}
	
	@GetMapping("/doctors/{doctorId}")
	public Doctor getDoctorByid(@PathVariable("doctorId") int id){
		return doctorService.getDoctorById(id);
	}
	@GetMapping("/doctors/{speciality}")
	public List<Doctor> getDoctorBySpeciality(@PathVariable("speciality") String speciality){
		return doctorService.getDoctorBySpeciality(speciality);
	}
	
	@PutMapping("/doctors/{doctorId}")
	public Doctor update(@PathVariable("doctorId") int id, @RequestBody Doctor doc) {
		return doctorService.updateDoctor(id, doc);
	}
	
	@PostMapping("/doctors")
	@ResponseStatus(code = HttpStatus.OK)
	public Doctor saveDoctor(@RequestBody Doctor doc) {
		
		return doctorService.save(doc);
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
