package org.elsys.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {

	private List<Employee> employees;
	
	public Company() {
		employees = new ArrayList<>();
	}
	
	public void addEmployee(Employee employee) {
		if (!hasEmployed(employee)) {
			employees.add(employee);
		}
	}
	
	public boolean hasEmployed(Employee employee) {
		return employees.contains(employee);
	}
	
	public List<Employee> getEmployeesBySalary() {
		List<Employee> result = new ArrayList<>(employees);
		result.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary() - o2.getSalary();
			}
		});
		return result;
	}
}
