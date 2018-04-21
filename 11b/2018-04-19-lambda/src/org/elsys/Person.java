package org.elsys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Person {

	private String name;
	private Gender gender;
	private int age;

	public Person(String name, Gender gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public static List<Person> filter(List<Person> people, Filter filter) {

		ArrayList<Person> result = new ArrayList<Person>();
		for (Person p : people) {
			if (filter.match(p)) {
				result.add(p);
			}
		}
		return result;
	}

	public static void main(String argv[]) {
		List<Person> people = Arrays.asList(new Person("Ivan", Gender.MALE, 25),
		        new Person("Ivanka", Gender.FEMALE, 20),
		        new Person("Pencho", Gender.OTHER, 17));

		List<Person> under23 = filter(people, new Filter() {

			@Override
			public boolean match(Person p) {
				return p.getAge() < 23;
			}

		});

		System.out.println("under 23:" + under23.size());

		List<Person> under30notMale = filter(people, new Filter() {

			@Override
			public boolean match(Person p) {
				return p.getAge() < 30 && p.getGender() != Gender.MALE;
			}

		});
		System.out.println("under 30 not male:" + under30notMale.size());

		under23 = filter(people, p -> p.getAge() < 23);
		System.out.println("under 23:" + under23.size());

		under30notMale = filter(people,
		        p -> p.getAge() < 30 && p.getGender() != Gender.MALE);
		System.out.println("under 30 not male:" + under30notMale.size());

		people.sort(new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getAge() - p2.getAge();
			}

		});

		people.sort((p1, p2) -> p1.getAge() - p2.getAge());

		people.forEach(p -> {
			if(p.getAge() < 18) {
				System.out.println("under age: " + p.getName());
			} else {
				System.out.println("upper age: " + p.getName());
			}
		});
	}
}
