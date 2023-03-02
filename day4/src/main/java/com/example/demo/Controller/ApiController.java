package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Student;
import com.example.demo.Repositories.StudentRepo;
import com.example.demo.Service.ApiService;

@RestController
public class ApiController {

	@Autowired
	StudentRepo serviceRepository;
    @Autowired
    ApiService service;
    
    @GetMapping("/getvalues")
    List<Student>getList(){
  	  return serviceRepository.findAll();
    }
    @PutMapping("/student")
    public String update(@RequestBody Student stu) {
  	  return service.updateDetails(stu);
    }
    @DeleteMapping("/student")
    public String delete(@RequestParam int id) {
  	  return service.deleteDetails(id);
    }
  
}
