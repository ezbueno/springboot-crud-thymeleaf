package com.buenoezandro.crud.services.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.buenoezandro.crud.dtos.EmployeeRecord;
import com.buenoezandro.crud.entities.Employee;
import com.buenoezandro.crud.mappers.EmployeeMapper;
import com.buenoezandro.crud.repositories.EmployeeRepository;
import com.buenoezandro.crud.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final EmployeeMapper employeeMapper;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
		this.employeeRepository = employeeRepository;
		this.employeeMapper = employeeMapper;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return this.employeeRepository.findById(id).orElse(null);
	}

	@Override
	public boolean saveOrUpdateEmployee(EmployeeRecord employeeRecord) {
		Employee emp = this.employeeRepository.save(this.employeeMapper.fromDTOToEntity(employeeRecord));
		return Objects.nonNull(this.employeeRepository.findById(emp.getId()));
	}

	@Override
	public boolean deleteEmployee(Integer id) {
		if (this.employeeRepository.findById(id).isPresent()) {
			this.employeeRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
