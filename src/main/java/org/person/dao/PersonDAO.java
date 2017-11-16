package org.person.dao;

import java.util.List;

import org.person.entity.Person;

public interface PersonDAO {
	void add(Person p);

	void addAll(List<Person> pl);

	List<Person> findByName(String name);

	Person findById(long id);
}
