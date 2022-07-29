package com.cjc.in.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class Course {

	@Id
	private int cid;
	private String cname;
	private String profName;
	private String description;
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> stu=new ArrayList<Student>();
	
	
}
