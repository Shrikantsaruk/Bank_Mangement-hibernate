package com.shri.bms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shri.bms.dto.Account;
import com.shri.bms.dto.Customer;

public class CustomerCrud {

	
	public Customer saveCustomer(Customer customer,Account account) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		if(customer!=null)
		entityTransaction.begin();
		entityManager.persist(customer);
		entityManager.persist(account);
		entityTransaction.commit();
		
		return customer;
	}
	public Customer updateCustomer(Customer customer2,int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Customer customer=entityManager.find(Customer.class, id);
		if(customer!=null) {
			customer.setName(customer2.getName());
			customer.setEmail(customer2.getEmail());
			customer.setAddress(customer2.getAddress());
			customer.setDob(customer2.getDob());
			customer.setPan(customer2.getPan());
		
			
		entityTransaction.begin();
		entityManager.merge(customer);
		entityTransaction.commit();
		}
		return customer;
	}
	public Customer deleteCustomer(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Customer customer=entityManager.find(Customer.class, id);
		if(customer!=null) {
		entityTransaction.begin();
		entityManager.remove(customer);
		entityTransaction.commit();
		}
		return customer;
	}
	public Customer getById(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Customer customer=entityManager.find(Customer.class, id);
		
		return customer;
	}

	}


