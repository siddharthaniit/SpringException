package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.StudentNotFoundException;
import com.example.model.Student;
import com.example.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@RequestBody Student student)
	{
		studentRepository.save(student);
		return "Success";
	}
	
	@RequestMapping(value="/getAll")
	public List<Student> getAll()
	{
		return (List<Student>) studentRepository.findAll();
		
	}
	
	@RequestMapping(value="/getId/{id}")
   public Optional<Student> getById(@PathVariable int id)
   {
		
			Optional<Student> findById = studentRepository.findById(id);
			
			
			if(!findById.isPresent())
				throw new StudentNotFoundException("student record not found" +id);
			
			return findById;
   }
	/*@RequestMapping(value="/getById/{id}")
	   public Student getId(@PathVariable int id)
	   {	
		
		Student findOne = studentRepository.findOne(id);
		int id1 = findOne.getId();
		if(id1 == 0)
		{
	   throw new StudentNotFoundException("student record not found" +id);
	
		}
		return findOne;
	   }
*/
	
}
