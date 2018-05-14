package org.elsys.todo;

import static org.junit.Assert.*;

import org.elsys.todo.Criteria;
import org.elsys.todo.Priority;
import org.elsys.todo.Status;
import org.elsys.todo.TodoList;
import org.junit.Test;

public class TodoListImplTest {

	private TodoList todoList = TodoList.parse(
			"TODO    | Do OOP homework              | Low    | school, programming\r\n" + 
			"TODO    | Get 8 hours of sleep.        | Low    | health\r\n" + 
			"DOING   | Party hard.                  | Normal | social\r\n" + 
			"DONE    | Netflix and chill.           | Normal | tv shows\r\n" + 
			"TODO    | Find missing socks.          | Low    | meh\r\n" + 
			"");
	
	private TodoList completedTodoList = TodoList.parse(
			"DONE    | Do OOP homework              | Low    | school, programming\r\n" + 
			"DONE    | Get 8 hours of sleep.        | Low    | health\r\n" + 
			"DONE    | Party hard.                  | Normal | social\r\n" + 
			"DONE    | Netflix and chill.           | Normal | tv shows\r\n" + 
			"DONE    | Find missing socks.          | Low    | meh\r\n" + 
			"");
	
	@Test
	public void testIsCompleted() {
		assertEquals(false, todoList.isCompleted());
		assertEquals(true, completedTodoList.isCompleted());
	}

	@Test
	public void testGetTasks() {
		assertEquals(5, todoList.getTasks().size());
	}
	
	@Test
	public void filterByStatus() {
		TodoList filtered = todoList.filter(Criteria.status(Status.DOING));
		assertEquals(1, filtered.getTasks().size());
	}
	
	@Test
	public void filterByPriority() {
		assertEquals(0, todoList.filter(Criteria.priority(Priority.HIGH))
				.getTasks().size());
		assertEquals(2, todoList.filter(Criteria.priority(Priority.NORMAL))
				.getTasks().size());

	}
	
	@Test
	public void filterByNotCriteria() {
		assertEquals(5, todoList
				.filter(Criteria.priority(Priority.HIGH).not())
				.getTasks().size());
		assertEquals(3, todoList
				.filter(Criteria.priority(Priority.NORMAL).not())
				.getTasks().size());

	}	
	
	
	
	
	

}
