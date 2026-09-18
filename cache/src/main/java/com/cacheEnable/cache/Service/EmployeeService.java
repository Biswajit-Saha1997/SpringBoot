package com.cacheEnable.cache.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cacheEnable.cache.Entity.Employee;
import com.cacheEnable.cache.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Cacheable(value="employee", key="#id")
	public Employee getDetailsById(String id) {
		
		System.out.println("Fetching employee from MongoDB...");
		return employeeRepository.findById(id)
				.orElseThrow();

	}
	
	@Cacheable(value="employees", key="#pageable")
	public Page<Employee> getDetails(Pageable pageable) {
		
		System.out.println("Fetching employees from MongoDB...");
		return employeeRepository.findAll(pageable);

	}

	public boolean createEmployee(Employee emp) {

		employeeRepository.save(emp);
		return true;
	}

	@CachePut(value="employee",key="#id")
	public boolean updateEmployee(String id,Employee emp) {
		
		if(id!=null) {
		Employee oldEmployee= employeeRepository.findById(id).orElse(null);
			if(oldEmployee != null) {
				if(oldEmployee.getName() != emp.getName() || oldEmployee.getAddress()!= emp.getAddress()) {
					employeeRepository.deleteById(id);
					employeeRepository.save(emp);
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}
		return false;
	}
	
	
}
