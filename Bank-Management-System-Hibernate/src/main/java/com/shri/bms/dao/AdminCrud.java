package com.shri.bms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shri.bms.dto.Admin;
import com.shri.bms.dto.BankManager;

public class AdminCrud {

	
	public Admin saveAdmin(Admin admin) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		if(admin!=null)
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		
		return admin;
	}
	public Admin updateAdmin(Admin admin2,int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Admin admin=entityManager.find(Admin.class, id);
		if(admin!=null) {
			admin.setName(admin2.getName());
			admin.setEmail(admin2.getEmail());
			admin.setPassword(admin2.getPassword());
			
		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();
		}
		return admin;
	}
	public Admin deleteAdmin(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Admin admin=entityManager.find(Admin.class, id);
		if(admin!=null) {
		entityTransaction.begin();
		entityManager.remove(admin);
		entityTransaction.commit();
		}
		return admin;
	}
	public Admin getById(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Admin admin=entityManager.find(Admin.class, id);
		
		return admin;
	}
	
	public int approvingBankManager(int id,String password,int bmid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Admin admin=entityManager.find(Admin.class, id);
		if( admin!=null && admin.getPassword().equals(password)) {
			System.out.println("Admin log in sucessfully");
			BankManager bankManager=entityManager.find(BankManager.class, bmid);
			if (bankManager!=null) {
				bankManager.setStatus("Approved");
				entityTransaction.begin();
				entityManager.merge(bankManager);
				entityTransaction.commit();
			}
			return 1;
		}else
			System.out.println("log in failed");
		return -1;

	}
	
	}

