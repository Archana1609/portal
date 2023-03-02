package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
      @Autowired
      StudentRepository serviceRepository;
      @Autowired
      StudentService service;
      
      @GetMapping("/getvalues")
      List<StudentEntity>getList(){
    	  return serviceRepository.findAll();
      }
      @PostMapping("/post")
      public StudentEntity create(@RequestBody StudentEntity stu) {
    	  return serviceRepository.save(stu);
      }
      @GetMapping("/getvalues/{id}")
    	  public Optional<StudentEntity>getbyid(@PathVariable int id){
    		  return service.getStudentEntity(id);
    	  }
      @PutMapping("/student")
      public String update(@RequestBody StudentEntity stu) {
    	  return service.updateDetails(stu);
      }
      @DeleteMapping("/student")
      public String delete(@RequestParam int id) {
    	  return service.deleteDetails(id);
      }
      @GetMapping("/student/{offset}/{pageSize}")
      public List<StudentEntity>studentWithPagination(@PathVariable int offset,@PathVariable int pageSize){
    	  return service.setPages(offset,pageSize);
      }
      @GetMapping("/student/{field}")
      public List<StudentEntity>studentSortList(@PathVariable String field){
    	  return service.getSort(field);
      }
      @GetMapping("/sortandpage/{offset}/{pageno}/{field}")
      public Page<StudentEntity>sortPagination(@PathVariable int offset,@PathVariable int pageno,@PathVariable String field){
    	  return service.dosortandPage(offset, pageno, field);
      }
      
      }