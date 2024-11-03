package com.akash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.model.Student;
import com.akash.service.Studentservice;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class Homecontroller {
	
	@Autowired
	private Studentservice service;

	
	
	@GetMapping(path="/students",produces = {"application/json"})
	public List<Student> getStudents() {
		System.out.println("returned list of students");
		return service.getStudents();	
	}
	
	@GetMapping("/student/{id}")
	public Student getonestudent(@PathVariable("id")int id) {
		return service.getonestudent(id);	
	}
	
	@PostMapping(path="/student")//,consumes={"application/xml"}
	public void postonestudent(@RequestBody  Student student) {
		service.postonestudent(student);
		System.out.println("posted succesfully");
	}
	
	@DeleteMapping("/student/{id}")
	public void deleteone(@PathVariable("id")int id) {
		
		 service.deleteone(id);
		 System.out.println("deleted succesfully");

	}
	
	@PutMapping("/student/{id}")
	public void  changeone(@PathVariable("id")int id,
		@RequestBody Student student) {
		service.changeone(id,student);
		System.out.println("updated");
	}
	
	@GetMapping("/keyword/{keyword}")
	public List<Student> getcourses(@PathVariable("keyword") String keyword) {
		return service.getcourses(keyword);
		
	}
	
}
