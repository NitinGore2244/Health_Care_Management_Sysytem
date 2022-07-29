package com.cjc.in.service;

import java.util.List;

import com.cjc.in.model.Course;
import com.cjc.in.model.CourseDTO;

public interface CourseService {
	
	String addCourse(Course c);

	
	String deleteCourse(int cid);
	
	Course getSingle(int cid);
}
