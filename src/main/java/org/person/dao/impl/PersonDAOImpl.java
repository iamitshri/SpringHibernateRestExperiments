package org.person.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.person.dao.PersonDAO;
import org.person.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO{
	
	@PersistenceContext
	EntityManager em;
	
	public PersonDAOImpl() {}

	 
	public void add(Person p) {
		if(p!=null) {
			em.persist(p);
		}
		
	}

	
	public void addAll(List<Person> pl) {
		 for(Person p : pl) {
			 em.persist(p);
		 }
		
	}

	
	public List<Person> findByName(String name) {
	  TypedQuery<Person> q = em.createQuery("Select p from Person p where p.name = :name",Person.class);
	  q.setParameter("name",name);
	  return q.getResultList();
		
	}

	
	public Person findById(long id) {
		return em.find(Person.class, id);
		
	}

}
