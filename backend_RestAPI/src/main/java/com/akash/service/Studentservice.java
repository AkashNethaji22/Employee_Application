package com.akash.service;

import java.util.List;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akash.CustomException.ResourceNotFoundException;
import com.akash.model.Student;
import com.akash.repo.StudentRepo;

@Service
public class Studentservice {
	
	@Autowired
	private StudentRepo repo;
	
	
    public List<Student> getStudents(){
	return repo.findAll();
	   
   }


	public Student getonestudent(int id) {
				return repo.findById(id)
						.orElseThrow(()-> new ResourceNotFoundException("Requested Data does not exists "+id));
	}


	public void postonestudent(Student student) {
         repo.save(student);		
	}


	public void deleteone(int id) {
		if(!repo.existsById(id)) {
		 throw new ResourceNotFoundException("Requested Data does not exists "+id);
		}
		
		repo.deleteById(id);
	}


	public void changeone(int id, Student student) {
		 Student orginaldata=repo.findById(id).orElseThrow(()->new RuntimeException("data not found"));
         
		  orginaldata.setName(student.getCourse());;
		  orginaldata.setCourse(student.getName());
		  
		  repo.save(orginaldata);
	 }





	public List<Student> getcourses(String keyword) {
		// TODO Auto-generated method stub
//		System.out.println("print");
		return repo.findByCourseContainingOrNameContaining(keyword,keyword);
		
	}

		/*
		 * return repo.findById(id).orElse(new Student(0,"unknown","not yet"));
		 */
}

