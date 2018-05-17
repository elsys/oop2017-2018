package org.elsys.todo;

import java.util.List;
import java.util.function.Consumer;

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
	Double completedPercentage();

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
	 * Returns the count of the tasks that match the criteria.
	 * @param criteria
	 * @return
	 */
	int count(Criteria criteria);

	/**
	 * Passes each task to the consumer's accept method.
	 * @param consumer
	 */
	void each(Consumer<Task> consumer);

	/**
	 * Joins two instances of TodoList, removing the duplicating tasks.
	 * @param other
	 * @return
	 */
	TodoList join(TodoList other);

	/**
	 * Percentage of tasks, matching the criteria.
	 * @param criteria
	 * @return
	 */
	Double matchingPercentage(Criteria criteria);

	/**
	 * Percentage of tasks having the provided status.
	 * @param status
	 * @return
	 */
	Double statusPercentage(Status status);
}
