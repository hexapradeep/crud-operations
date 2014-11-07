package com.hexagone.springHiberCrud;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional

public interface EmployeeService 
{
	public void addEmployee(Employee e);
    public void updateEmployee(Employee e);
    public Employee getEmployeeById(int id);
    public void removeEmployee(int id);
	
}
