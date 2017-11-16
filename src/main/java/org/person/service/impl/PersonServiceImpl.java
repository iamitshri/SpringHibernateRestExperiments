package org.person.service.impl;

import java.util.List;


import org.person.dao.PersonDAO;
import org.person.entity.Person;
import org.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

	public PersonServiceImpl() {

	}

	@Autowired
	PersonDAO dao;
	
	@Transactional
	public void add(Person p) {
		dao.add(p);

	}

	@Transactional
	public void addAll(List<Person> pl) {
		dao.addAll(pl);

	}

	@Transactional(readOnly=true)
	public List<Person> findByName(String name) {
		return dao.findByName(name);
	}

	@Transactional(readOnly=true)
	public Person findById(long id) {
		return dao.findById(id);
	}

}
