package com.cjc.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.in.model.Course;
import com.cjc.in.service.CourseService;

@RestController
@RequestMapping("/courseApi")
public class CourseController {
	
	
	@Autowired
	private CourseService service;
	
	@PostMapping("/addCourse")
	public ResponseEntity<String> addCourse(@RequestBody Course c)
	{
		String string = service.addCourse(c);
		return new ResponseEntity<String>(string,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteCourse/{cid}")
	public ResponseEntity<String> deleteCourse(@PathVariable int cid)
	{
		String string = service.deleteCourse(cid);
		return new ResponseEntity<String>(string,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getCourse/{cid}")
	public ResponseEntity<Course> getCourse(@PathVariable int cid)
	{
		Course course = service.getSingle(cid);
		return new ResponseEntity<Course>(course,HttpStatus.FOUND);
	}

}
