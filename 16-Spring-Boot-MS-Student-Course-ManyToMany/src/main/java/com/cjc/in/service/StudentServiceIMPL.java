package com.cjc.in.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.in.exception.CourseNotFound;
import com.cjc.in.exception.StudentIdNotMatch;
import com.cjc.in.exception.StudentNotFound;
import com.cjc.in.model.Course;
import com.cjc.in.model.Student;
import com.cjc.in.model.StudentDTO;
import com.cjc.in.repository.CourseRepository;
import com.cjc.in.repository.StudentRepository;

@Service
public class StudentServiceIMPL implements StudentService {

	@Autowired
	private StudentRepository repo;
	
	@Autowired
	private CourseRepository crepo;
	
	@Override
	public String addStudent(Student stu) {
		
		if(stu.getSid()>99&&stu.getSid()<999)
		{
			repo.save(stu);
			return "Student Added Successfully";
		}
		throw new StudentIdNotMatch();
	}

	@Override
	public String addCourse(int sid, int cid) {
		
		Optional<Student> optional = repo.findById(sid);
		System.out.println(optional.get());
		if(optional.isPresent())
		{
			Student st = optional.get();
			Optional<Course> optional2 = crepo.findById(cid);
			if(optional2.isPresent())
			{
				Course course = optional2.get();
				st.getCourses().add(course);
			
				repo.save(st);
				course.getStu().add(st);
				crepo.save(course);
				
				return "Course Added Successfully";
			}
			
			throw new CourseNotFound();
		}
		throw new StudentNotFound();
	}

	@Override
	public List<StudentDTO> getAlLStudents() {
		
		
		List<StudentDTO> dtoList=new ArrayList<StudentDTO>();
		
		List<Student> stulist = repo.findAll();
		
		for(Student stu:stulist)
		{
			StudentDTO dto=new StudentDTO();
			
			dto.setSid(stu.getSid());
			dto.setName(stu.getName());
			dto.setEmail(stu.getEmail());
			dto.setPhoneno(stu.getPhoneno());
			List<String> list = dto.getCourses();
			
			
			for(Course clist:stu.getCourses())
			{
				list.add(clist.getCname());
				 
			}
			
			dtoList.add(dto);
		}
		
		
		return dtoList;
	}

}
