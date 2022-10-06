package com.shri.bms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shri.bms.dto.Account;
import com.shri.bms.dto.BankManager;
import com.shri.bms.dto.Customer;
import com.shri.bms.dto.CustomerRequested;

public class BankManagerCrud {

	
	public BankManager saveBankManager(BankManager bankManager) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		if(bankManager!=null)
		entityTransaction.begin();
		entityManager.persist(bankManager);
		entityTransaction.commit();
		
		return bankManager;
	}
	public BankManager updateBankManager(BankManager bankManager2,int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		BankManager bankManager=entityManager.find(BankManager.class, id);
		if(bankManager!=null) {
			bankManager.setName(bankManager2.getName());
			bankManager.setEmail(bankManager2.getEmail());
			bankManager.setPassword(bankManager2.getPassword());
			
		entityTransaction.begin();
		entityManager.merge(bankManager);
		entityTransaction.commit();
		}
		return bankManager;
	}
	public BankManager deleteBankManager(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		BankManager bankManager=entityManager.find(BankManager.class, id);
		if(bankManager!=null) {
		entityTransaction.begin();
		entityManager.remove(bankManager);
		entityTransaction.commit();
		}
		return bankManager;
	}
	public BankManager getById(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		BankManager bankManager=entityManager.find(BankManager.class, id);
		
		return bankManager;
	}
	
	public Account approvingCustomer(int id,String password, int cid,Account account) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		BankManager bankManager=entityManager.find(BankManager.class, id);
		if(bankManager!=null && bankManager.getPassword().equals(password)) {
		    CustomerRequested customerRequested=entityManager.find(CustomerRequested.class, cid);
	    	if (customerRequested!=null && customerRequested.getStatus().equals("unapprove")) {
			    customerRequested.setStatus("Approved");
		    	Customer customer=new Customer();
			    customer.setName(customerRequested.getName());
		    	customer.setEmail(customerRequested.getEmail());
		    	customer.setDob(customerRequested.getDob());
	    		customer.setAddress(customerRequested.getAddress());
		    	customer.setPan(customerRequested.getPan());
		    	customer.setAccount(account);
			
			   CustomerCrud customerCrud=new CustomerCrud();
			   customerCrud.saveCustomer(customer,account);
			return account;
		}
	  }else
		  System.out.println("bank log in failed");
		return account;
	}
	
	}

	

