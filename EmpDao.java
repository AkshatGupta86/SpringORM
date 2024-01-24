package com.springorm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.springorm.entities.Emp;

public class EmpDao 
{
private HibernateTemplate hibernateTemplate;

//save data
@Transactional
public int insert(Emp emp)
{
	Integer i=(Integer)this.hibernateTemplate.save(emp);
	return i;
}
//get single data
public Emp getData(int empId)
{
	Emp emp=this.hibernateTemplate.get(Emp.class, empId);
	return emp;
}
//get multiple data
public List<Emp> getAllData()
{
	List<Emp> emps=this.hibernateTemplate.loadAll(Emp.class);
	return emps;
}
//delete data
@Transactional //used for update only
public int deleteData(int empId)
{
	Emp emps=this.hibernateTemplate.get(Emp.class, empId);
	this.hibernateTemplate.delete(emps);
	return empId;
}
//update data
@Transactional
public void updateData(Emp existingEmp)
{
	this.hibernateTemplate.update(existingEmp);
}
 
//setter getter applied
public HibernateTemplate getHibernateTemplate(){
	return hibernateTemplate;
}
public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
	this.hibernateTemplate = hibernateTemplate;
}
}