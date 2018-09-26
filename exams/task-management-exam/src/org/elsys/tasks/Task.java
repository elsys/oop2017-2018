package org.elsys.tasks;

import java.util.Collection;

public class Task {

	public Task(long id, String name, String description, boolean solutionRequired) {
	}

	public long getId() {
	    return 0;
	}

	public String getName() {
		return null;
	}

	public String getDescription() {
		return null;
	}

	public boolean isSolutionRequired() {
		return false;
	}

	public boolean hasSolutionById(long id) {
		return false;
	}

	public void addSolution(TaskSolution solution) {
	}

	public void addOrUpdateSolution(TaskSolution solution) {
	}

	public int getSolutionsSize() {
	    return 0;
	}

	public Collection<TaskSolution> getSolutions() {
		return null;
	}

	public TaskSolution getSolutionById(long id) {
		return null;
	}

	public Collection<TaskSolution> getSolutionsByStatus(Status status) {
	    return null;
	}

	public Collection<TaskSolution> getSolutionsByConfirmation(boolean confirmed) {
	    return null;
	}

}
