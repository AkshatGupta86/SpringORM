package com.springorm.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Emp 
{
@Id
private int empId;
private String name;
private String email;
private String state;
private String department;
public Emp(int empId, String name, String email, String state, String department) {
	super();
	this.empId = empId;
	this.name = name;
	this.email = email;
	this.state = state;
	this.department = department;
}
public Emp() {
	super();
	// TODO Auto-generated constructor stub
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
@Override
public String toString() {
	return "Emp [empId=" + empId + ", name=" + name + ", email=" + email + ", state=" + state + ", department="
			+ department + "]";
}
}