package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;



/*
 * public interface PersonRepo extends CrudRepository<Person, Integer> {
 * 
 * List<Person> findBypersonName(String personName); }
 */

public interface PersonRepo extends JpaRepository<Person, Integer>{
	
	List<Person> findBypersonName(String personName);
}