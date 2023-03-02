package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Book;
import com.example.demo.Repositories.Bookrepo;
import com.example.demo.Service.ApiService;


@RestController
public class ApiController {
    
	@Autowired
    Bookrepo serviceRepository;
    @Autowired
    ApiService service;
    
    @GetMapping("/getvalues")
    List<Book>getList(){
  	  return serviceRepository.findAll();
    }
    @PostMapping("/post")
    public Book create(@RequestBody Book stu) {
  	  return serviceRepository.save(stu);
    }
    @GetMapping("/getvalues/{id}")
  	  public Optional<Book>getbyid(@PathVariable int id){
  		  return service.getBook(id);
  	  }
    @PutMapping("/student")
    public String update(@RequestBody Book stu) {
  	  return service.updateDetails(stu);
    }
    @DeleteMapping("/student")
    public String delete(@RequestParam int id) {
  	  return service.deleteDetails(id);
    }
}
