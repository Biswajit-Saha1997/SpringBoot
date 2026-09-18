package com.Filter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Filter.Entity.Student;

@Service
public class StudentService {

    public ArrayList<Student> getAllStudents() {

    	return new ArrayList<>(
    		    List.of(
    		        new Student(1, "Ron", "Kolkata", "Class-A"),
    		        new Student(2, "Amit", "Delhi", "Class-B"),
    		        new Student(3, "Rahul", "Mumbai", "Class-A"),
    		        new Student(4, "Priya", "Bangalore", "Class-C"),
    		        new Student(5, "Ankit", "Kolkata", "Class-B"),
    		        new Student(6, "Sneha", "Chennai", "Class-A"),
    		        new Student(7, "Vikash", "Pune", "Class-C"),
    		        new Student(8, "Neha", "Hyderabad", "Class-B"),
    		        new Student(9, "Rohan", "Kolkata", "Class-A"),
    		        new Student(10, "Suman", "Delhi", "Class-C")
    		    )
    		);
    }
}