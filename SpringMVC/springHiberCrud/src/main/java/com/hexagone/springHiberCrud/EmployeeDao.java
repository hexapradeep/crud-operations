package com.hexagone.springHiberCrud;

public interface EmployeeDao 
{
		public void addEmployee(Employee e);
	    public void updateEmployee(Employee e);
	    public Employee getEmployeeById(int id);
	    public void removeEmployee(int id);
}
