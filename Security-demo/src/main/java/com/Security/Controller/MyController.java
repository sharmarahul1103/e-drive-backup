package com.Security.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Security.Entity.Student;
import com.Security.Entity.UserInfo;
import com.Security.Service.StudentService;
import com.Security.Service.UserInfoService;

@RestController
public class MyController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	UserInfoService userInfoService;
	
	@GetMapping("/test")
	public String test()
	{
		return "hello from test";
	}
	@GetMapping("/demo")
	public String demo()
	{
		return "hello from demo";
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserInfo> addUser(@RequestBody UserInfo userInfo)
	{
	UserInfo u1=userInfoService.addUser(userInfo);
	  return ResponseEntity.ok(u1);
	}
	
	
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student)
	{
		System.out.println("inside request");
	  Student s=studentService.saveStudent(student);
	  return ResponseEntity.ok(s);
	}
	
	@GetMapping("getStudents")
	public ResponseEntity<List<Student>> getStudents()
	{
		List<Student> students= studentService.getAllStudents();
		return ResponseEntity.ok(students);
	}

}
