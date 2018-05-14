package org.elsys.todo;

import org.elsys.todo.impl.PriorityCriteria;
import org.elsys.todo.impl.StatusCriteria;

/**
 * Interface used for filtering {@link TodoList}s.
 */
public interface Criteria {

	/**
	 * Creates new Criteria instance for matching {@link Task}s with the given
	 * status.
	 * 
	 * @param status
	 * @return the new Criteria instance
	 */
	public static Criteria status(Status status) {
		return new StatusCriteria(status);
	}

	/**
	 * Creates new Criteria instance for matching {@link Task}s with the given
	 * priority.
	 * 
	 * @param priority
	 * @return the new Criteria instance
	 */
	public static Criteria priority(Priority priority) {
		return new PriorityCriteria(priority);
	}

	/**
	 * Creates new Criteria instance for matching {@link Task}s with the given
	 * tags.
	 * 
	 * @param tags
	 * @return the new Criteria instance
	 */
	public static Criteria tags(String[] tags) {
		// TODO implement me
		return null;
	}

	/**
	 * Creates new Criteria instance representing conjunction with the provided
	 * as argument Criteria.
	 * 
	 * @param other
	 * @return the new Criteria instance
	 */
	Criteria and(Criteria other);

	/**
	 * Creates new Criteria instance representing disjunction with the provided
	 * as argument Criteria.
	 * 
	 * @param other
	 * @return the new Criteria instance
	 */
	Criteria or(Criteria other);

	/**
	 * Creates new Criteria instance representing negation of the Criteria.
	 * 
	 * @param other
	 * @return the new Criteria instance
	 */
	Criteria not();

}
