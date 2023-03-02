package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model;
import com.example.demo.repo.Erepo;

@Service
public class Eservice {
	@Autowired
	Erepo repo;
	public List<model>findByDeptAndName(String d,String n){
		return repo.findByDeptOrName(d,n);
	}
	public List<model>findByDeptAndName1(String d,String n){
		return repo.findByDeptAndName(d,n);
	}
	public List<model>findBySalaryIn(List<Double>sal){
		return repo.findBySalary(sal);
	}
	public List<model>findByNameStartingWith(String a){
		return repo.findByNameStartingWith(a);
	}
	public List<model>findByNameEndingWith(String b){
		return repo.findByNameEndingWith(b);
	}
	
	public List<model> getallusers(){
		return repo.getallusers();
		}

	public List<model> getallusersname(String n){
		return repo.getallusersname(n);
		}

	public List<model> getallusersname(String n,String d){
		return repo.getallusersname(n,d);
		}
	public int getalluseral(double sal,long id) {
		return repo.getallusersalary(sal, id);
	}
	public int deleteEmployeeDetails(long id) {
		int delRes=repo.deleteEmployeeDetails(id);
		  return delRes;
	}

}
