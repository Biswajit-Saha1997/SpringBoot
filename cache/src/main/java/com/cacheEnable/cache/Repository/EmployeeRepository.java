package com.cacheEnable.cache.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cacheEnable.cache.Entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}