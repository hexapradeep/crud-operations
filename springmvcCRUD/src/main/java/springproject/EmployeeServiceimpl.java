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
	public void addEmployee(Employee employee) 
	{
		this.employeedao.addEmployee(employee);

	}

	@Transactional
	public void updateEmployee(Employee employee) {
		this.employeedao.updateEmployee(employee);

	}
	@Transactional
	public Employee getEmployeeById(int employeeId ) {
		return this.employeedao.getEmployeeById(employeeId);

	}
	@Transactional
	public void removeEmployee(int employeeId) {
		this.employeedao.removeEmployee(employeeId);

	}
	@Transactional
	public List<Employee> listemployees() {
		return this.employeedao.listemployees();

	}


}