package org.elsys.tasks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaskTestCase {

	private Task task1;
	private Task task2;

	private TaskSolution sol1;
	private TaskSolution sol11;
	private TaskSolution sol2;

	@Before
	public void setUp() throws Exception {
		task1 = new Task(1, "test1", "test description 1", true);
		task2 = new Task(2, "test2", "test description 2", false);
		sol1 = new TaskSolution(1);
		sol11 = new TaskSolution(1);
		sol2 = new TaskSolution(2);
	}

	@Test
	public void testGetId() {
		assertEquals(1, task1.getId());
		assertEquals(2, task2.getId());
	}

	@Test
	public void testGetName() {
		assertEquals("test1", task1.getName());
		assertEquals("test2", task2.getName());
	}

	@Test
	public void testGetDescription() {
		assertEquals("test description 1", task1.getDescription());
		assertEquals("test description 2", task2.getDescription());
	}

	@Test
	public void testIsSolutionRequired() {
		assertTrue(task1.isSolutionRequired());
		assertFalse(task2.isSolutionRequired());
	}

	@Test
	public void testAddSolution() {
		task1.addSolution(sol1);
		task1.addSolution(sol2);

		assertEquals(2, task1.getSolutionsSize());

	}

	@Test
	public void testAddedSolutionBelongsToTask() {
		task1.addSolution(sol1);
		task1.addSolution(sol2);

		assertEquals(2, task1.getSolutionsSize());

		assertEquals(task1, sol1.getTask());
		assertEquals(task1, sol2.getTask());
	}

	public void testAddingSolutionWithSameTask() {
		sol1.setTask(task1);
		assertFalse(task1.hasSolutionById(sol1.getId()));

		task1.addSolution(sol1);
		assertTrue(task1.hasSolutionById(sol1.getId()));
	}

	@Test(expected = RuntimeException.class)
	public void testAddingSolutionWithDifferentTaskThrows() {
		sol1.setTask(task2);
		task1.addSolution(sol1);
	}

	@Test(expected = RuntimeException.class)
	public void testDoubleAddThrows() {
		task1.addSolution(sol1);
		task1.addSolution(sol11);
	}

	@Test
	public void testDoubleAddOrUpdateUpdates() {
		sol1.setDescription("sol1");
		sol11.setDescription("sol11");
		
		task1.addOrUpdateSolution(sol1);
		assertEquals("sol1", task1.getSolutionById(1).getDescription());
		task1.addOrUpdateSolution(sol11);
		assertEquals("sol11", task1.getSolutionById(1).getDescription());
	}
}
