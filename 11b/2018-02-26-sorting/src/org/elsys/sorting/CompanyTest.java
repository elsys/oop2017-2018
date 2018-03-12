package org.elsys.sorting;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class CompanyTest {

	@Test
	public void testAddEmployee() {
		Company company = new Company();
		Employee employee = new Employee(1, "Emil", 300);
		company.addEmployee(employee);
		assertTrue(company.hasEmployed(employee));
		assertFalse(company.hasEmployed(
				new Employee(2, "Ivan", 100)));
		assertTrue(company.hasEmployed(
				new Employee(1, "Emil", 300)));
	}
	
	@Test
	public void testGetEmployeesBySalary() {
		Company company = new Company();
		company.addEmployee(new Employee(1, "Emil", 300));
		company.addEmployee(new Employee(2, "Ivan", 200));
		company.addEmployee(new Employee(3, "SS", 3000));
		List<Employee> employees =
				company.getEmployeesBySalary();
		assertEquals(2, employees.get(0).getId());
		assertEquals(1, employees.get(1).getId());
		assertEquals(3, employees.get(2).getId());
	}

}
