package org.elsys.streams.practice;

import static java.util.Arrays.asList;
import static org.elsys.streams.practice.PeopleStats.getStats;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.elsys.streams.practice.Person;
import org.junit.Test;

public class PeopleStatsTest {

	private Person sara = new Person("Sara", 4);
	private Person viktor = new Person("Viktor", 40);
	private Person eva = new Person("Eva", 42);
	private List<Person> collection = asList(sara, eva, viktor);

	@Test
	public void getStatsShouldReturnAverageAge() {
		assertEquals((double) (4 + 40 + 42) / 3, getStats(collection).getAverage(), 0.001);
	}

	@Test
	public void getStatsShouldReturnNumberOfPeople() {
		assertEquals(3, getStats(collection).getCount());
	}

	@Test
	public void getStatsShouldReturnMaximumAge() {
		assertEquals(42, getStats(collection).getMax());
	}

	@Test
	public void getStatsShouldReturnMinimumAge() {
		assertEquals(4, getStats(collection).getMin());
	}

	@Test
	public void getStatsShouldReturnSumOfAllAges() {
		assertEquals(40 + 42 + 4, getStats(collection).getSum());
	}

}
