package org.person.rest.service;

import java.util.Date;
import java.util.List;

import org.person.entity.Person;
import org.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {

	public PersonController() {

	}

	@Autowired
	PersonService ps;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	String index(String name, String address, String email) {
		return "Welcome to the world of spring and dragons";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseBody
	void addPerson(String name, String address, String email) {
		Person p = new Person();
		p.setName(name);
		p.setAddress(address);
		p.setEmail(email);
		p.setDate_created(new Date());
		ps.add(p);
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET,  headers="Accept=*/*", produces = "application/json")
	@ResponseBody
	List<Person> findPerson(String name) {
		return ps.findByName(name);
	}

}
