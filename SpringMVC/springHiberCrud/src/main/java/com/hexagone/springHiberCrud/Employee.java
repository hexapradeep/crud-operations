package com.hexagone.springHiberCrud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="employee1")
@Proxy(lazy=false)

public class Employee
{
	@Id
	@Column(name="empid")
	private int id;
	@Column(name="empname")
	private String empName;
	@Column(name="salary")
	private double salary;
	@Column(name="country")
	private String country;
	@Column(name="city")
	private String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", salary="
				+ salary + ", country=" + country + ", city=" + city + "]";
	}
	
	
	
}
