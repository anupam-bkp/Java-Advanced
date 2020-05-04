package com.anupam.springboottest4.database.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.anupam.springboottest4.database.entity.Customer;

@Repository
@Transactional
public class CustomerJpaRepository {

	//Connect to database
	
	@PersistenceContext
	EntityManager em;
	
	
	public Customer updateCustomer(Customer customer) {
		return em.merge(customer);
	}
	
	public Customer insertCustomer(Customer customer) {
		return em.merge(customer);
	}
	
	public Customer retrieveCustomerById(int id) {
		return em.find(Customer.class, id);
	}
	
	public List<Customer> retrieveAllCustomer() {
		TypedQuery<Customer> namedQuery = em.createNamedQuery("find_all_persons", Customer.class);
		return namedQuery.getResultList();
	}
	
	public void deleteById(int id) {
		
		Customer customer = retrieveCustomerById(id);
		
		em.remove(customer);
	}
}
