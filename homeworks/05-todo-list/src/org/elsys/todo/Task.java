package org.elsys.todo;

public interface Task {

	Status getStatus();

	String getDescription();

	Priority getPriority();

	String[] getTags();
}
