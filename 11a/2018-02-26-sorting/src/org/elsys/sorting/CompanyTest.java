package org.elsys.sorting;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class CompanyTest {

	@Test
	public void testAddEmployee() {
		Company company = new Company();
		company.addEmployee(
				new Employee(1, "Emil Gotsev", 3000));
		assertTrue(company.isEmployed(
				new Employee(1, "Emil Gotsev", 3000)));
		assertFalse(company.isEmployed(
				new Employee(2, "Ivan Ivanov", 1000)));
	}

	@Test
	public void testGetEmployeesBySalary() {
		Company company = new Company();
		company.addEmployee(
				new Employee(1, "Emil Gotsev", 3000));
		company.addEmployee(
				new Employee(2, "Bai Ivan", 2000));
		company.addEmployee(
				new Employee(3, "SS", 2500));
		
		List<Employee> employees = company.getEmployeesBySalary();
		assertEquals(2, employees.get(0).getId());
		assertEquals(3, employees.get(1).getId());
		assertEquals(1, employees.get(2).getId());
	}
}
