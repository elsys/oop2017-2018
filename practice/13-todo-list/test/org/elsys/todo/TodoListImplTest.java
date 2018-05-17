package org.elsys.todo;

import static org.junit.Assert.*;

public class TodoListImplTest {

	private TodoList todoList = TodoList.parse(
			"TODO    | Do OOP homework              | Low    | school, programming\r\n" + 
			"TODO    | Get 8 hours of sleep.        | Low    | health\r\n" + 
			"DOING   | Party hard.                  | Normal | social\r\n" + 
			"DONE    | Netflix and chill.           | Normal | tv shows\r\n" + 
			"TODO    | Find missing socks.          | Low    | meh\r\n" + 
			"");
	
	// TODO implement tests
}
