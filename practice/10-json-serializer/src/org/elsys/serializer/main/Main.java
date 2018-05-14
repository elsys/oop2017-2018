package org.elsys.serializer.main;

import java.util.Arrays;

import org.elsys.serializer.JsonSerializer;
import org.elsys.serializer.Serializer;

public class Main {

	public static void main(String[] args) {
		Student student = new Student();
		student.setName("Pesho");
		student.setFatherName("Ivanov");
		student.setLastName("Peshev");
		student.setGrades(Arrays.asList(2, 5, 6));

		Serializer serializer = new JsonSerializer();
		serializer.setPretty(true);
		String result = serializer.serialize(student);
		serializer.includeNullFields(false);
		System.out.println(result);
	}

}
