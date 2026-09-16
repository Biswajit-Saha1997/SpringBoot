package com.SpringBootExceptionHandlingApplication.ExceptionHandling.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootExceptionHandlingApplication.ExceptionHandling.Entity.Employee;
import com.SpringBootExceptionHandlingApplication.ExceptionHandling.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/{id}")
	public Employee getDetails(@PathVariable String id) {

		return employeeService.getDetailsById(id);
	}
	
	@GetMapping()
	public Page<Employee> getDetails(@RequestParam (defaultValue="0") int page, @RequestParam (defaultValue="5") int size ) {

		Pageable pageable = PageRequest.of(page, size);
		
		
		return employeeService.getDetails(pageable);
	}

	@PostMapping
	public boolean CreateEmployee(@RequestBody Employee emp) {

		return employeeService.createEmployee(emp);

	}

}
