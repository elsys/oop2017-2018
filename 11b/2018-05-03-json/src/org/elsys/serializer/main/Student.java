package org.elsys.serializer.main;

import java.util.List;

import org.elsys.serializer.Ignore;
import org.elsys.serializer.MapAs;

public class Student {
	
	@MapAs("alaBalaPortokala")
	private String name;
	
	@MapAs("last_name")
	private String lastName;
	
	@Ignore
	private List<Integer> grades;
	
	@Ignore
	@MapAs("father_name")
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
