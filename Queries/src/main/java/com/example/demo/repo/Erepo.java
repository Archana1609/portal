package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model;

public interface Erepo extends JpaRepository<model,Long>{

	public List<model>findByDeptOrName(String d,String n);
	public List<model>findByDeptAndName(String d,String n);
	
	public List<model>findBySalary(List<Double>sal);
	public List<model>findByNameStartingWith(String a);
	public List<model>findByNameEndingWith(String b);
	
	@Query("select u from model u")
	public List<model> getallusers();

	@Query("select u from model u where u.name=:a")
	public List<model> getallusersname(@Param("a") String name);

	@Query("select u from model u where u.name=:a or u.dept=:d")
	public List<model> getallusersname(@Param("a") String name,@Param ("d")String dep);

	@Modifying
	@Query("UPDATE model c set c.salary=:s where c.id=:id")
	public int getallusersalary(@Param ("s")double sal,@Param ("d")Long id);
	
	@Modifying
	@Query("DELETE FROM model emp WHERE emp.id=:id")
	public int deleteEmployeeDetails(@Param("id")long id);

}
