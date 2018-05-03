package org.elsys.serializer.main;

import java.util.List;

import org.elsys.serializer.MapBy;

public class Student {
	
	@MapBy("first_name")
	private String name;
	
	@MapBy("last_name")
	private String lastName;
	
	private List<Integer> grades;
	
	@MapBy("father_name")
	private String fatherName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Integer> getGrades() {
		return grades;
	}

	public void setGrades(List<Integer> grades) {
		this.grades = grades;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
}
