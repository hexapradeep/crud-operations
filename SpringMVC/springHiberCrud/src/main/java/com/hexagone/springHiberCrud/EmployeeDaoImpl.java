package com.hexagone.springHiberCrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class EmployeeDaoImpl implements EmployeeDao
{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

public void addEmployee(Employee e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(e);


	}

	public void updateEmployee(Employee e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(e);

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
