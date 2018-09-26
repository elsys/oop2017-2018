package org.elsys.tasks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaskControllerTestCase {

	private TaskController taskController;
	private Task task1;
	private Task task2;
	private Task task11;

	@Before
	public void setUp() throws Exception {
		taskController = new TaskController();
		task1 = new Task(1, "test1", "test description 1", true);
		task2 = new Task(2, "test2", "test description 2", false);
		task11 = new Task(1, "test11", "test description 11", false);
	}

	@Test
	public void testAdd() {
		assertTrue(taskController.add(task1));
		assertTrue(taskController.add(task2));
		assertEquals(2, taskController.size());
	}

	@Test
	public void testAddSameTaskTwice() {
		assertTrue(taskController.add(task1));
		assertFalse(taskController.add(task1));
		assertEquals(1, taskController.size());
	}

	@Test
	public void testDifferentTaskWithSameId() {
		assertTrue(taskController.add(task1));
		assertFalse(taskController.add(task11));
		assertEquals(1, taskController.size());
	}
}
