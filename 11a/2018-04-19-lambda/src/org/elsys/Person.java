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
		List<Person> result = new ArrayList<Person>();
		for (Person p : people) {
			if (filter.match(p)) {
				result.add(p);
			}
		}
		return result;
	}

	public static void main(String[] argv) {
		List<Person> people = Arrays.asList(new Person("Ivanka", Gender.FEMALE, 18),
		        new Person("Penka", Gender.FEMALE, 38),
		        new Person("Gancho", Gender.MALE, 17),
		        new Person("Goshko", Gender.MALE, 48),
		        new Person("Pencho", Gender.OTHER, 33));

		List<Person> under35 = filter(people, new Filter() {

			@Override
			public boolean match(Person p) {
				return p.getAge() < 35;
			}

		});
		System.out.println("under 35: " + under35.size());

		List<Person> under35notMale = filter(people, new Filter() {
			@Override
			public boolean match(Person p) {
				return p.getAge() < 35 && p.getGender() != Gender.MALE;
			}
		});
		System.out.println("under 35 not male: " + under35notMale.size());

		under35 = filter(people, p -> p.getAge() < 35);
		System.out.println("under 35: " + under35.size());
		under35notMale = filter(people,
		        p -> p.getAge() < 35 && p.getGender() != Gender.MALE);
		System.out.println("under 35 not male: " + under35notMale.size());

		people.sort(new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getAge() - p2.getAge();
			}

		});

		people.sort((p1, p2) -> p1.getAge() - p2.getAge());
		people.forEach(p -> {
			System.out.println("age: " + p.getAge() + "; name: " + p.getName());
		});
		
		people.sort((p1, p2)->p1.getGender().compareTo(p2.getGender()));
		people.forEach(p -> {
			System.out.println(
					"gender: " + p.getGender() +
					"; age: " + p.getAge() + "; name: " + p.getName());
		});
	}
}
