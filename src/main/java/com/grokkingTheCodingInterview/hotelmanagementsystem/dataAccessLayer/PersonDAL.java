package com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.Person;

@Component
public class PersonDAL {
	
	List<Person> personList;
	static int id = 0;
	public PersonDAL() {
		personList = new ArrayList<Person>();
	}
	
	public Person createEmployee(Person person) {
		Person newPerson = person;
		newPerson.setId(++id);
		if(personList.add(newPerson))
			return newPerson;
		return null;		
	}
}
