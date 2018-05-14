package org.elsys.todo;

import java.util.List;

import org.elsys.todo.impl.TodoListImpl;

public interface TodoList {

	/**
	 * Parses the input String and creates new instance of TodoList.
	 * @param input
	 * @return new instance of TodoList
	 */
	public static TodoList parse(String input) {
		return new TodoListImpl(input);
	}

	/**
	 * Checks if the TodoList is completed.
	 * @return
	 */
	Boolean isCompleted();

	/**
	 * Percentage of completed tasks.
	 * @return Double, with 2-digits precision.
	 */
	Double percentageCompleted();

	/**
	 * @return all tasks in the to-do list.
	 */
	List<Task> getTasks();

	/**
	 * Returns new to-do list, filtered by the provided criteria.
	 * @param criteria
	 * @return
	 */
	TodoList filter(Criteria criteria);

	/**
	 * Joins two instances of TodoList, removing the duplicating tasks.
	 * @param other
	 * @return
	 */
	TodoList join(TodoList other);
}
