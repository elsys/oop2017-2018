package org.elsys.tasks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaskSolutionCreateTestCase {

	private Task task1;
	private Task task2;
	private TaskSolution taskSolution1;
	private TaskSolution taskSolution2;

	@Before
	public void setUp() throws Exception {
		task1 = new Task(1, "test1", "test description 1", true);
		task2 = new Task(2, "test2", "test description 2", false);
	}

	@Test
	public void testCreateTaskSolution() {
		taskSolution2 = new TaskSolution(2, task2);
		assertEquals(2, taskSolution2.getId());
		assertEquals(task2, taskSolution2.getTask());
		assertEquals(Status.NOT_STARTED, taskSolution2.getStatus());
		assertFalse(taskSolution2.isConfirmed());
	}

	@Test(expected = RuntimeException.class)
	public void testDoubleCreateThrows() {
		taskSolution1 = new TaskSolution(1, task1);
		taskSolution2 = new TaskSolution(1, task1);
	}

	@Test
	public void testTaskContatinsCreatedSolution() {
		taskSolution1 = new TaskSolution(1, task1);
		assertEquals(taskSolution1, task1.getSolutionById(1));
		assertTrue(taskSolution1 == task1.getSolutionById(1));
	}
	
	@Test
	public void testSetDescription() {
		
	}
}
