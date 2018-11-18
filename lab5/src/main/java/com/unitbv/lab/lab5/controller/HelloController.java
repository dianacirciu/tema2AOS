package com.unitbv.lab.lab5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unitbv.lab.lab5.entity.Person;
import com.unitbv.lab.lab5.repository.PersonRepository;

@RestController
@RequestMapping(value = "/tema2")
public class HelloController
{
        
    @RequestMapping(value = "/{name}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String sayHello(@PathVariable String name) {
		return "Hello, " + name;
	}
    
	
	@Autowired
	PersonRepository personRepository;
	
	@GetMapping("/all")
	public List<Person> getAll()
	{
		return personRepository.findAll();
	}
	
	@RequestMapping(value = "/create/{name}",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> persist(@PathVariable String name)
	{
		personRepository.save(new Person(name));
		return personRepository.findAll();
	}
	
	@DeleteMapping("/users/{user_id}")
	public List<Person> delete(@PathVariable("id") Integer id)
	{
		personRepository.deleteById(id);
		return personRepository.findAll();
	}
	
	@GetMapping("/update/{id}/{name}")
    public Person update(@PathVariable("id") final Integer id, @PathVariable("name")
                         final String name) {


        Person person = personRepository.getOne(id);
        person.setName(name);
        return personRepository.save(person);
	}
	
	
}
