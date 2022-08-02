package com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

}
