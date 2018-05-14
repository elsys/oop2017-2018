package org.elsys.edu;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class HighSchool implements EducationalInstitution {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean signUpForNextYear(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean signOut(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Student> getStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentsInCourse(int course, boolean orderedByAverageGrade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> order(Comparator<Student> comparator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Student> filter(Predicate<Student> predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, List<Student>> groupStudentsByGrade() {
		// TODO Auto-generated method stub
		return null;
	}

}
