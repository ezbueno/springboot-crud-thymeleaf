package com.buenoezandro.crud.mappers.impl;

import org.springframework.stereotype.Component;

import com.buenoezandro.crud.dtos.EmployeeRecord;
import com.buenoezandro.crud.entities.Employee;
import com.buenoezandro.crud.mappers.EmployeeMapper;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {
	@Override
	public EmployeeRecord fromEntityToDTO(Employee employee) {
		return new EmployeeRecord(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(), 
				employee.getDateOfBirth(),
				employee.getGender());
	}

	@Override
	public Employee fromDTOToEntity(EmployeeRecord employeeRecord) {
		return new Employee(
				employeeRecord.id(),
				employeeRecord.firstName(),
				employeeRecord.lastName(),
				employeeRecord.email(), 
				employeeRecord.dateOfBirth(),
				employeeRecord.gender());
	}
}
