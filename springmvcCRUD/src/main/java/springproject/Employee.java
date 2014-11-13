package springproject;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employee2")
@Proxy(lazy=false)

public class Employee
{
	@Id
	@GeneratedValue
	@Column(name="empid")
	private int employeeId;
	
	@Column(name="empname")   
	private String employeeName; 
	
	@Column(name="country")
	private String country;
	
	@Column(name="salary")
	private int employeeSalary;
	
	@Column(name="age")	
	private int employeeAge;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date joiningDate;
	
	@Column(name="joiningDate")
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public int getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", country=" + country + ", employeeSalary="
				+ employeeSalary + ", employeeAge=" + employeeAge
				+ ", joiningDate=" + joiningDate + "]";
	}
	
	
	
	
	}
	
	
	
	