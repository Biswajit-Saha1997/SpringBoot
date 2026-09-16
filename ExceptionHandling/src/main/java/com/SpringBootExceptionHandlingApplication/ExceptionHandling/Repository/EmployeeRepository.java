package com.SpringBootExceptionHandlingApplication.ExceptionHandling.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.SpringBootExceptionHandlingApplication.ExceptionHandling.Entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}