package com.akash.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.akash.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
    
//	@Query("select s from Student s where s.course=?1")
//	 public List<Student>  findByCourse(String course);

	public List<Student> findByCourseContainingOrNameContaining(String course,String name );

}
