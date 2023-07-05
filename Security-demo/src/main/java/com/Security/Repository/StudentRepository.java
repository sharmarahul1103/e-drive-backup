package com.Security.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Security.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@SuppressWarnings("unchecked")
	Student save(Student student);
	
	
	
	

}
