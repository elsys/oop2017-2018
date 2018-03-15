package org.elsys;

import java.util.Scanner;

import org.elsys.model.Student;

public class HelloWorld {

	private static final String WORLD_TYPE = "Java";

	public static void main(String[] args) {
		System.out.printf("Hello, %s World!", WORLD_TYPE);

		Student st = new Student("Ivan");
		changeName(st, "Ivan Ivanov");

		System.out.println(st.getName());

	}

	private static void changeName(Student st, String newName) {
		st.setName(newName);
	}

}
