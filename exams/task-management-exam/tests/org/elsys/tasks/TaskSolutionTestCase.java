package org.elsys.tasks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaskSolutionTestCase {

	private Task task;
	private TaskSolution taskSolution;
	
	@Before
	public void setUp() throws Exception {
		task = new Task(1, "test1", "test description 1", true);
		taskSolution = new TaskSolution(1, task);
	}

	@Test
	public void testInitialValues() {
		assertEquals(1, taskSolution.getId());
		assertEquals(task, taskSolution.getTask());
		assertEquals(Status.NOT_STARTED, taskSolution.getStatus());
		assertFalse(taskSolution.isConfirmed());
		assertNull(taskSolution.getDescription());
	}

	@Test
	public void testSetStatus() {
		taskSolution.setStatus(Status.STARTED);
		assertEquals(Status.STARTED, taskSolution.getStatus());
		taskSolution.setStatus(Status.COMPLETED);
		assertEquals(Status.COMPLETED, taskSolution.getStatus());
	}
	
	@Test
	public void testSetDescription() {
		taskSolution.setDescription("solved");
		assertEquals("solved", taskSolution.getDescription());
	}
	
	@Test
	public void testSetConfirmed() {
		taskSolution.setConfirmed(true);
		assertTrue(taskSolution.isConfirmed());
		taskSolution.setConfirmed(false);
		assertFalse(taskSolution.isConfirmed());
	}
}
