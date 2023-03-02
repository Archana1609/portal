package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;
	
	public Optional<StudentEntity>getStudentEntity(int id){
		return repository.findById(id);
	}
	public String updateDetails(StudentEntity stu) {
		repository.save(stu);
		return "updated";
	}
	public String deleteDetails(int id) {
		repository.deleteById(id);
		return "ID deleted";
	}
	public List<StudentEntity>setPages(@PathVariable int offset,@PathVariable int pageSize){
		Page<StudentEntity>page=repository.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}
	public List<StudentEntity>getSort(String field){
		return repository.findAll(Sort.by(Sort.Direction.DESC,field));
	}
	public Page<StudentEntity>dosortandPage(int offset,int pageSize,String field){
		Pageable pageable=PageRequest.of(offset, pageSize,Sort.by(Direction.DESC,field));
		return repository.findAll(pageable);
	}
}
