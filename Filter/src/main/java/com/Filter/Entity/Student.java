package com.Filter.Entity;


public class Student {

	Integer id;
	String name;
	String address;
	String section;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public Student(Integer id, String name, String address, String section) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.section = section;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", section=" + section + "]";
	}
	
}
