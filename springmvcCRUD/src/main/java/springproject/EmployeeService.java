package springproject;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional

public interface EmployeeService 
{
	public void addEmployee(Employee empployee);
    public void updateEmployee(Employee employee);
    public List<Employee> listemployees();
    public Employee getEmployeeById(int employeeId);
    public void removeEmployee(int employeeId);
	
}