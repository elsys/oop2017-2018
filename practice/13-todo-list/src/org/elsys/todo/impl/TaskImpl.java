package org.elsys.todo.impl;

import org.elsys.todo.Priority;
import org.elsys.todo.Status;
import org.elsys.todo.Task;

public class TaskImpl implements Task {

	private Status status;
	private String description;
	private Priority priority;
	private String[] tags;
	
	public TaskImpl(Status status, String description,
			Priority priority, String[] tags) {
		this.status = status;
		this.description = description;
		this.priority = priority;
		this.tags = tags;
	}

	@Override
	public Status getStatus() {
		return status;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public Priority getPriority() {
		return priority;
	}

	@Override
	public String[] getTags() {
		return tags;
	}

}
