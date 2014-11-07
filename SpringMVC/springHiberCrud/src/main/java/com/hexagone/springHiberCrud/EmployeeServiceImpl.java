package com.hexagone.springHiberCrud;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly=true)

public class EmployeeServiceImpl implements EmployeeService
{

	private EmployeeDao employeedao;
	
	public EmployeeDao getEmployeedao() {
		return employeedao;
	}

	public void setEmployeedao(EmployeeDao employeedao) {
		this.employeedao = employeedao;
	}

	public void addEmployee(Employee e) 
	{
		this.employeedao.addEmployee(e);
		
	}
	

	public void updateEmployee(Employee e) {
		this.employeedao.updateEmployee(e);
		
	}
	
	public Employee getEmployeeById(int id) {
		return this.employeedao.getEmployeeById(id);
	
	}
	
	public void removeEmployee(int id) {
		this.employeedao.removeEmployee(id);
		
	}
	

}
