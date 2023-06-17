package com.buenoezandro.crud.services;

import java.util.List;

import com.buenoezandro.crud.dtos.EmployeeRecord;
import com.buenoezandro.crud.entities.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	Employee getEmployeeById(Integer id);

	boolean saveOrUpdateEmployee(EmployeeRecord employeeRecord);

	boolean deleteEmployee(Integer id);
}
