package com.springorm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.EmpDao;
import com.springorm.entities.Emp;

public class App 
{
	public static void main(String[] args){
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		EmpDao empDao=context.getBean("empDao", EmpDao.class);
//		Emp e=new Emp();
//		e.setEmpId(1);
//		e.setName("Akshat");
//		e.setEmail("gakshu06@gmail.com");
//		e.setState("Haryana");
//		e.setDepartment("Software Developer");
		
//		int ins=empDao.insert(e);
//		System.out.println("Data Inserted"+ins);
		
		Scanner sc=new Scanner(System.in);
		boolean b=true;
		while(b)
		{
			System.out.println("Enter 1 to insert new data");
			System.out.println("Enter 2 to get single data");
			System.out.println("Enter 3 to get All data");
			System.out.println("Enter 4 to delete data");
			System.out.println("Enter 5 to update data");
			System.out.println("Enter 6 for exit");
			try{
				int input=sc.nextInt();
				switch(input)
				{
				case 1:
					//add data
					System.out.println("Enter Id");
					int empId=sc.nextInt();
					System.out.println("Enter Name");
					String name=sc.next();
					System.out.println("Enter Email");
					String email=sc.next();
					System.out.println("Enter State");
					String state=sc.next();
					System.out.println("Enter Department");
					String department=sc.next();
					Emp e=new Emp();
					e.setEmpId(empId);
					e.setName(name);
					e.setEmail(email);
					e.setState(state);
					e.setDepartment(department);
					int ins=empDao.insert(e);
					System.out.println("Data Inserted"+ins);
					
					break;					
				case 2:
					//get single data
					System.out.println("Enter Id");
					int eid=sc.nextInt();
					Emp ds=empDao.getData(eid);
					System.out.println("id:"+ds.getEmpId());
					System.out.println("name:"+ds.getName());
					System.out.println("email:"+ds.getEmail());
					System.out.println("state:"+ds.getState());
					System.out.println("department:"+ds.getDepartment());
					
					break;				
				 case 3:
					//get All data
					List<Emp> emp=empDao.getAllData();
					for(Emp ee:emp){
						System.out.println("id:"+ee.getEmpId());
						System.out.println("name:"+ee.getName());
						System.out.println("email:"+ee.getEmail());
						System.out.println("state:"+ee.getState());
						System.out.println("department:"+ee.getDepartment());
					}
					break;					
				 case 4:
					 //delete
					 System.out.println("Enter Id to delete:");
	                 int deleteId = sc.nextInt();
	                 int del = empDao.deleteData(deleteId);
	                 System.out.println("Data deleted: " + del);
					 
			        break;					 
				 case 5:
					 //update
					 System.out.println("Enter Id to update:");
	                 int updateId = sc.nextInt();
	                 Emp existingEmp = empDao.getData(updateId);

	                 if (existingEmp != null) {
	                 // Display existing data
	                 System.out.println("Existing Data:");
	                 System.out.println("id:" + existingEmp.getEmpId());
	                 System.out.println("name:" + existingEmp.getName());
	                 System.out.println("email:" + existingEmp.getEmail());
	                 System.out.println("state:" + existingEmp.getState());
	                 System.out.println("department:" + existingEmp.getDepartment());

	                 // Accept new data
	                 System.out.println("Enter new Name");
	                 String newName = sc.next();
	                 System.out.println("Enter new Email");
	                 String newEmail = sc.next();
	                 System.out.println("Enter new State");
	                 String newState = sc.next();
	                 System.out.println("Enter new Department");
	                 String newDepartment = sc.next();

	                 // Update the existing entity
	                 existingEmp.setName(newName);
	                 existingEmp.setEmail(newEmail);
	                 existingEmp.setState(newState);
	                 existingEmp.setDepartment(newDepartment);

	                 // Save the updated entity
	                 empDao.updateData(existingEmp);
	                 System.out.println("Data updated successfully");
	                 }
	                 else {
	                 System.out.println("No data found for the given ID");
	                 }
					 
			         break;
					 case 6:
					 b=false;
					 
					 break;
					 
					 default:
						 System.out.println("Enter valid details");
					}
			}
			catch(Exception e){
				//TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
