package com.Security.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Security.Entity.Student;
import com.Security.Repository.StudentRepository;

@Service
public class StudentService  {

	@Autowired
	StudentRepository studentRepository;
	
	public Student saveStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}
	
	
}
