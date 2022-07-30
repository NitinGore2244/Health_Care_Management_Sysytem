package com.cjc.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.in.model.Student;
import com.cjc.in.model.StudentDTO;
import com.cjc.in.service.StudentService;

@RestController
@RequestMapping("/stuApi")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/addStudent")
	public ResponseEntity<String> addStudent(@RequestBody Student stu)
	{
		String string = service.addStudent(stu);
		return new ResponseEntity<String>(string,HttpStatus.CREATED);
	}
	
	@GetMapping("/addcourseToStudent/{sid}/{cid}")
	public ResponseEntity<String> addCourseToStudent(@PathVariable int sid,@PathVariable int cid)
	{
		String string = service.addCourse(sid, cid);
		return new ResponseEntity<String>(string,HttpStatus.OK);
	}
	
	@GetMapping("/getAllStudent")
	public ResponseEntity<List<StudentDTO>> getAll()
	{
		List<StudentDTO> list = service.getAlLStudents();
		return new ResponseEntity<List<StudentDTO>>(list,HttpStatus.FOUND);
	}
	
}
