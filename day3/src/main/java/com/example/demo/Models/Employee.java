package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
      @Id
      private int id;
  	  private String name;
  	  private String iscompleted;
	public Employee(int id, String name, String iscompleted) {
		super();
		this.id = id;
		this.name = name;
		this.iscompleted = iscompleted;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIscompleted() {
		return iscompleted;
	}
	public void setIscompleted(String iscompleted) {
		this.iscompleted = iscompleted;
	}
  	  
     /* private int id;
      private String employeeName;
      private int employeeAge;
      private long salary;
	public Employee(int id, String employeeName, int employeeAge, long salary) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.salary = salary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}*/
      
}
