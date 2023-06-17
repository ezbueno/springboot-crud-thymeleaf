package com.buenoezandro.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buenoezandro.crud.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
