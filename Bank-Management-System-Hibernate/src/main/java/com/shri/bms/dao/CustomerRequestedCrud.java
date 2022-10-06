package com.shri.bms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shri.bms.dto.CustomerRequested;

public class CustomerRequestedCrud {

	public CustomerRequested saveBankCustomerReq(CustomerRequested customer) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		if(customer!=null)
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		
		return customer;
	}
}
