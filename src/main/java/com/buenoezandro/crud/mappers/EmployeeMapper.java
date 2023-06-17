package com.buenoezandro.crud.mappers;

import com.buenoezandro.crud.dtos.EmployeeRecord;
import com.buenoezandro.crud.entities.Employee;

public interface EmployeeMapper {
	EmployeeRecord fromEntityToDTO(Employee employee);

	Employee fromDTOToEntity(EmployeeRecord employeeRecord);
}
