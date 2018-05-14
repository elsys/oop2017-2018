package org.elsys.edu;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public interface EducationalInstitution {

	/**
	 * Name of the educational institution.
	 * 
	 * @return
	 */
	String getName();

	/**
	 * Sings up the student for the next year.
	 * 
	 * @param student
	 * @return
	 */
	boolean signUpForNextYear(Student student);

	/**
	 * Signs out the student from the educational institution.
	 * 
	 * @param student
	 * @return
	 */
	boolean signOut(Student student);

	/**
	 * Returns all the currently signed students.
	 * 
	 * @return
	 */
	Collection<Student> getStudents();

	/**
	 * Returns all the students in the given course.
	 * 
	 * @param course
	 *            the course of the students
	 * @param orderedByAverageGrade
	 *            if the students should be ordered by average grade (ascending)
	 * @return
	 */
	List<Student> getStudentsInCourse(int course, boolean orderedByAverageGrade);

	/**
	 * Uses the comparator to order the list of students and returns it.
	 * 
	 * Should not change the inner state of the class!
	 * 
	 * @param comparator
	 * @return
	 */
	List<Student> order(Comparator<Student> comparator);

	/**
	 * Uses the passed predicate to filter out part of the students and returns the
	 * rest.
	 * 
	 * @param predicate
	 * @return
	 */
	Collection<Student> filter(Predicate<Student> predicate);

	/**
	 * Groups the students by their average grade.
	 * 
	 * @return
	 */
	Map<Integer, List<Student>> groupStudentsByGrade();
}
