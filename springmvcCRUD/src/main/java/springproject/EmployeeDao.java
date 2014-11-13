package springproject;

import java.util.List;

public interface EmployeeDao 
{
		public void addEmployee(Employee employee);
	    public void updateEmployee(Employee employee);
	    public List<Employee> listemployees();
	    public Employee getEmployeeById(int employeeId);
	    public void removeEmployee(int employeeId);
}


