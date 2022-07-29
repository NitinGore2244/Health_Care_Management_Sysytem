package com.cjc.in.service;

import java.util.List;

import com.cjc.in.model.Student;
import com.cjc.in.model.StudentDTO;

public interface StudentService {
	
	String addStudent(Student stu);
	
	String addCourse(int sid,int cid);
	
	List<StudentDTO> getAlLStudents();

}
