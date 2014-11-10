package springproject;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class EmployeeServiceimpl implements EmployeeService
{

	private EmployeeDao employeedao;
	
	public EmployeeDao getEmployeedao() {
		return employeedao;
	}

	public void setEmployeedao(EmployeeDao employeedao) {
		this.employeedao = employeedao;
	}
	@Transactional
	public void addEmployee(Employee e) 
	{
		this.employeedao.addEmployee(e);
		
	}
	
	@Transactional
	public void updateEmployee(Employee e) {
		this.employeedao.updateEmployee(e);
		
	}
	@Transactional
	public Employee getEmployeeById(int id) {
		return this.employeedao.getEmployeeById(id);
	
	}
	@Transactional
	public void removeEmployee(int id) {
		this.employeedao.removeEmployee(id);
		
	}
	@Transactional
	public List<Employee> listemployees() {
		 return this.employeedao.listemployees();
	
	}
	

}