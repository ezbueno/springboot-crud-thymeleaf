package com.buenoezandro.crud.services;

import java.util.List;

import com.buenoezandro.crud.entities.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	Employee getEmployeeById(Integer id);

	boolean saveOrUpdateEmployee(Employee employee);

	boolean deleteEmployee(Integer id);
}
