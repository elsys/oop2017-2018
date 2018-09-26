package org.elsys.tasks;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class TaskSolutionGetTestCases {

	private Task task;

	private TaskSolution sol1;
	private TaskSolution sol2;
	private TaskSolution sol3;
	
	@Before
	public void setUp() throws Exception {
		task = new Task(1, "test1", "test description 1", true);
		sol1 = new TaskSolution(1, task);
		sol2 = new TaskSolution(2, task);
		sol3 = new TaskSolution(3, task);
		sol1.setConfirmed(true);
		sol2.setConfirmed(true);
		
		sol1.setStatus(Status.STARTED);
		sol3.setStatus(Status.COMPLETED);
	}

	@Test
	public void testGetConfirmed() {
		Collection<TaskSolution> solutions = task.getSolutionsByConfirmation(true);
		assertEquals(2, solutions.size());
		
		assertTrue(solutions.contains(sol1));
		assertTrue(solutions.contains(sol2));
	}

	@Test
	public void testGetNotConfirmed() {
		Collection<TaskSolution> solutions = task.getSolutionsByConfirmation(false);
		assertEquals(1, solutions.size());
		
		assertTrue(solutions.contains(sol3));
	}

	
	@Test
	public void testGetStatusStarted() {
		Collection<TaskSolution> solutions = task.getSolutionsByStatus(Status.STARTED);
		assertEquals(1, solutions.size());
		assertTrue(solutions.contains(sol1));
		
		sol2.setStatus(Status.STARTED);
		solutions = task.getSolutionsByStatus(Status.STARTED);
		assertEquals(2, solutions.size());
		assertTrue(solutions.contains(sol1));
		assertTrue(solutions.contains(sol2));

		sol1.setStatus(Status.COMPLETED);
		solutions = task.getSolutionsByStatus(Status.STARTED);
		assertEquals(1, solutions.size());
		assertTrue(solutions.contains(sol2));
	}
}
