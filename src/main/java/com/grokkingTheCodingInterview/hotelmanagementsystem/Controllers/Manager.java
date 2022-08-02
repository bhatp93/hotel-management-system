package com.grokkingTheCodingInterview.hotelmanagementsystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.Person;
import com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer.PersonDAL;
import com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer.PersonRepository;

@RestController
public class Manager {
	
	@Autowired
	private PersonDAL personDAL;
	
	@Autowired
	private PersonRepository personRepo;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Person> addEmployee(@RequestBody Person person) {
		//Person createdPerson = personDAL.createEmployee(person);
		Person createdPerson = personRepo.save(person);
		return new ResponseEntity(createdPerson, HttpStatus.CREATED);
	}
	
	@GetMapping("/getHelloWorld")
	public String testGet() {
		return "Hello World";
	}

}
