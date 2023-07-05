package com.redis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.redis.entity.Student;
import com.redis.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo studentRepo;
	
	@Cacheable(cacheNames = "rediscache")
	public Student addStudent(Student s)
	{
	    return 	studentRepo.save(s);
	}
    
	@Cacheable(cacheNames = "rediscache")
	public Student getStudentbyId(Integer id )
	{
		return studentRepo.findById(id).orElseThrow();
	}
	
	
}
