package springproject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EmployeeDaoimpl implements EmployeeDao
{
	private static final Logger logger = LoggerFactory .getLogger(Employee.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(employee);
		logger.info("employee object saved successfully");

	}

	public void updateEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(employee);

	}
	public List<Employee> listemployees() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> emp = session.createQuery("from Employee").list();
		for(Employee p : emp){
			System.out.println("employess list"+emp);
		}
		return emp;
	}

	public Employee getEmployeeById(int employeeId) {
		Session session=this.sessionFactory.getCurrentSession();
		Employee employe=(Employee) session.load(Employee.class, new Integer(employeeId));
		return employe;
	}

	public void removeEmployee(int employeeId) {
		Session session=this.sessionFactory.getCurrentSession();
		Employee employee=(Employee) session.load(Employee.class, new Integer(employeeId));
		if(null!=employee){
			session.delete(employee);
		}

	}
}