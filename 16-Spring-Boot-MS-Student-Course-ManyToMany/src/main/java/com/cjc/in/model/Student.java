package com.cjc.in.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	
	@Id
	private int sid;
	private String name;
	private String email;
	private String phoneno;
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name = "student_course",joinColumns = {@JoinColumn(name="student_sid")},
	inverseJoinColumns = {@JoinColumn(name="course_cid")})
	@JsonIgnore
	private List<Course> courses;

}
