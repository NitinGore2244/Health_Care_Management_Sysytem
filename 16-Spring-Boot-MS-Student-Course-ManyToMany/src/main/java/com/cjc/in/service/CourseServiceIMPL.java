package com.cjc.in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.in.exception.CourseIDNotFound;
import com.cjc.in.exception.CourseIDNotMatch;
import com.cjc.in.model.Course;
import com.cjc.in.model.CourseDTO;
import com.cjc.in.repository.CourseRepository;
import com.cjc.in.repository.StudentRepository;

@Service
public class CourseServiceIMPL implements CourseService{

	
	@Autowired
	private CourseRepository repo;
	
	
	@Override
	public String addCourse(Course c) {
		
		if(c.getCid()>=1&&c.getCid()<100)
		{
			repo.save(c);
			return "Course Added Successfully";
		}
		
		throw new CourseIDNotMatch();
		
	}
	@Override
	public String deleteCourse(int cid) {
		
		List<Course> list = repo.findAll();
	
		for(Course c:list)
		{
			if(c.getCid()==cid)
			{
				repo.deleteById(cid);
				return "Course Deleted Successfully";
			}
			
			
		}
		throw new CourseIDNotFound();
	}
	@Override
	public Course getSingle(int cid) {
		Optional<Course> optional = repo.findById(cid);
		if(optional.isPresent())
		{
			Course course = optional.get();
			return course;
		}
		
		throw new CourseIDNotFound();
	}

}
