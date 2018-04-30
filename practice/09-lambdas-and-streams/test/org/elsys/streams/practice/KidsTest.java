package org.elsys.streams.practice;

import static java.util.Arrays.asList;
import static org.elsys.streams.practice.Kids.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class KidsTest {

	@Test
	public void getKidNameShouldReturnNamesOfYoungerThan18() {
		Person sara = new Person("Sara", 4);
		Person viktor = new Person("Viktor", 40);
		Person eva = new Person("Eva", 42);
		Person anna = new Person("Anna", 5);
		List<Person> collection = asList(sara, eva, viktor, anna);
		Set<String> kidNames = getKidNames(collection);
		assertTrue(kidNames.containsAll(asList("Sara", "Anna")));
		assertFalse(kidNames.containsAll(asList("Eva", "Viktor")));
	}

	@Test
	public void getKidAgeByNameShouldReturnMapWithYoungerThan18() {
		Person sara = new Person("Sara", 4);
		Person viktor = new Person("Viktor", 40);
		Person eva = new Person("Eva", 42);
		Person anna = new Person("Anna", 5);
		List<Person> collection = asList(sara, eva, viktor, anna);
		Map<String, String> ageByName = getKidsAgeByName(collection);
		assertTrue(ageByName.keySet().containsAll(asList("Sara", "Anna")));
		assertEquals(4, ageByName.get("Sara"));
		assertEquals(5, ageByName.get("Anna"));
	}

}
