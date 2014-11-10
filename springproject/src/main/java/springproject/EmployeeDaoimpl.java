package springproject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class EmployeeDaoimpl implements EmployeeDao
{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

public void addEmployee(Employee e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(e);


	}

	public void updateEmployee(Employee e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(e);

	}
	 public List<Employee> listemployees() {
	        Session session = this.sessionFactory.getCurrentSession();
	        List<Employee> emp = session.createQuery("from Employee").list();
	        for(Employee p : emp){
	            System.out.println("employess list"+emp);
	        }
	        return emp;
	    }

	public Employee getEmployeeById(int id) {
		Session session=this.sessionFactory.getCurrentSession();
		Employee e=(Employee) session.load(Employee.class, new Integer(id));
		return e;
	}

	public void removeEmployee(int id) {
		Session session=this.sessionFactory.getCurrentSession();
		Employee e=(Employee) session.load(Employee.class, new Integer(id));
		if(null!=e){
			session.delete(e);
		}

	}
}