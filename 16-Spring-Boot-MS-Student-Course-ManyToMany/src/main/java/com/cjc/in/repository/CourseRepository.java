package com.cjc.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.in.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	
}
