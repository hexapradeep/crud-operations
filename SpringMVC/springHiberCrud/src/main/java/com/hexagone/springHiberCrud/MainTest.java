package com.hexagone.springHiberCrud;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest 
{
public static void main(String[] args) 
{
	@SuppressWarnings("resource")
	ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
	EmployeeService service=(EmployeeService) context.getBean("EmployeeService");
	
	Employee emp=new Employee();
	emp.setId(12);
	emp.setEmpName("vijay");
	emp.setSalary(10256.56f);
	service.addEmployee(emp);
	
	/**read operation**/
	Employee emp1= service.getEmployeeById(10);
	System.out.println(emp1.getEmpName());
	System.out.println(emp1.getSalary());

	/** update operation **/
	Employee emp2=service.getEmployeeById(55);
	emp1.setEmpName("pradeepkumar");
	service.updateEmployee(emp2);
	System.out.println("update successfuly");

	/** delete operation **/
	service.removeEmployee(7);
	System.out.println("Done successfully");

	
}
}