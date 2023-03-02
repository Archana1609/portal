package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model;
import com.example.demo.Service.Eservice;

import jakarta.transaction.Transactional;

public class Econtroller {
     @Autowired
     Eservice service;
     
     @GetMapping("/findname/{name}/{dept}")
     public List<model>finddetails(@PathVariable String name,@PathVariable String dept)
       {
    	 return service.findByDeptAndName(dept,name);
    	 }
     @GetMapping("/findname/{name1}/{dept1}")
     public List<model>finddetails1(@PathVariable String name1,@PathVariable String dept1){
    	 return service.findByDeptAndName(dept1, name1);
     }
     @GetMapping("/getSalary")
     public List<model>findBysalaryIn(@RequestParam("salary")List<Double>sal){
    	 List<model>s1=service.findBySalaryIn(sal);
    	 return s1;
     }
     @GetMapping("/getnames/{start}")
     public List<model>findByname(@PathVariable("start")String start){
    	 return service.findByNameStartingWith(start);
     }
     @GetMapping("/getnames1/{end}")
     public List<model>findByNameEndingWith(@PathVariable("end") String end){
    	 return service.findByNameEndingWith(end);
     }
     
     @GetMapping("/getallusers")
     public List<model> getalluserList (){
     return service.getallusers();
      }

     @GetMapping("/getallusers/{name}")
     public List<model> getalluserListname (@PathVariable String name){
     return service.getallusersname(name);
     }

     @GetMapping("/getallusers/{name}/{dept}")
     public List<model> getalluserListname (@PathVariable String name,@PathVariable String dept){
     return service.getallusersname(name,dept);

     }
     @Transactional
     @PutMapping(value="/getallusers/{sal}/{id}")
     public String getalluserListname(@PathVariable("sal") double sal,@PathVariable long id) {
    	 String res="";
    	 int result=service.getalluseral(sal, id);
    	 if(result>0) {
    		 res="Salary updated"+result;
    		 System.err.println(res);
    	 }
    	 else {
    		 res="Not updated"+result;
    		 System.err.println(res);
    	 }
    	 return res;
     }
     @Transactional
     @DeleteMapping(value="/deleteEmployeeDetails/{id}")
     public String deleteEmployeeDetails(@PathVariable("id")long id) {
     String del="";
     int delRes=service.deleteEmployeeDetails(id);
     if(delRes>0) {
     del="id : "+""+id+" "+"Suceessfully deleted";
     System.err.println(del);
     }
     else {
            del="id : "+id+" "+"Not deleted!!!";
            System.err.println(del);
     }
      return del;
     }
}