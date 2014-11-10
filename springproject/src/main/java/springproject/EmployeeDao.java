package springproject;

import java.util.List;

public interface EmployeeDao 
{
		public void addEmployee(Employee e);
	    public void updateEmployee(Employee e);
	    public List<Employee> listemployees();
	    public Employee getEmployeeById(int id);
	    public void removeEmployee(int id);
}


