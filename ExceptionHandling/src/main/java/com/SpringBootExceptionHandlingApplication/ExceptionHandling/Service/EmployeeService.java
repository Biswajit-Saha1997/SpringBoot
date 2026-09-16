package com.SpringBootExceptionHandlingApplication.ExceptionHandling.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.SpringBootExceptionHandlingApplication.ExceptionHandling.Entity.Employee;
import com.SpringBootExceptionHandlingApplication.ExceptionHandling.Exception.EmployeeNotFoundException;
import com.SpringBootExceptionHandlingApplication.ExceptionHandling.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee getDetailsById(String id) {

		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " not found"));

	}
	
	public Page<Employee> getDetails(Pageable pageable) {

		return employeeRepository.findAll(pageable);

	}

	public boolean createEmployee(Employee emp) {

		employeeRepository.save(emp);
		return true;
	}

}
