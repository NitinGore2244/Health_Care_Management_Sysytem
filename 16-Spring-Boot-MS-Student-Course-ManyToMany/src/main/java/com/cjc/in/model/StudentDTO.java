package com.cjc.in.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

	
	private int sid;
	private String name;
	private String email;
	private String phoneno;
	
	private List<String> courses=new ArrayList<String>();
}
