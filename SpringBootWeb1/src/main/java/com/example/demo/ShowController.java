package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Jsp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ShowController {


	@Autowired
	PersonRepo personRepo;	
	
	@RequestMapping("/")
	public String show() {
		
		return "index";
	}
	
	@RequestMapping("/home")
	public String showing() {
		
		
		return "index.jsp";
	}

	 
	 @RequestMapping("/getPerson") 
	 public ModelAndView getPerson(@RequestParam int personId) { 
	
		ModelAndView modelAndView = new ModelAndView("");
		modelAndView.setViewName("getshow.jsp");
		Person person = personRepo.findById(personId).orElse(new Person());  
		modelAndView.addObject(person);
		
		return modelAndView;
	 }
	 
	 
	 @RequestMapping("/updatePerson") 
	 public ModelAndView updatePerson(@RequestParam String  personName) { 
	
		ModelAndView modelAndView = new ModelAndView("");
		modelAndView.setViewName("getshow.jsp");
		List<Person> personList = personRepo.findBypersonName("Java");
		modelAndView.addObject(personList);
		System.out.println(personRepo.findBypersonName("Java"));
		return modelAndView;
	 }
	 
		/*
		 * @RequestMapping("/persons")
		 * 
		 * @ResponseBody public String getAllPerson() { return
		 * personRepo.findAll().toString(); }
		 * 
		 * @RequestMapping("/persons/{personId}")
		 * 
		 * @ResponseBody public String getPersons( personId) { return
		 * personRepo.findById(personId).toString(); }
		 */
	 
		/*
		 * @RequestMapping(path="/persons",produces= {"application/xml"})
		 * 
		 * @ResponseBody public List<Person> getAllPerson() { return
		 * personRepo.findAll(); }
		 */
	 
	
	 
		

	 @PostMapping("/addPerson") 
	 public Person addPerson(Person person) { 
	

		personRepo.save(person);
		return person;
	 }
	 
	 
	 
	 @GetMapping(path="/persons",produces={"application/json"}) 
	 public List<Person> getAllPerson() { 
		return personRepo.findAll();
	 }
	 
	 
	 
	 
	 @RequestMapping("/persons/{personId}") 
	 @ResponseBody
	 public Optional<Person> getPersons(@PathVariable int personId) { 
		return personRepo.findById(personId);
	 }
	 
	 
}
