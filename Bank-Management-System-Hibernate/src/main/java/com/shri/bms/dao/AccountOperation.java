package com.shri.bms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shri.bms.dto.Account;

public class AccountOperation {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shri");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
 public double withdral(int id, long account_no,double amount) {
	Account account=entityManager.find(Account.class, id);
	if(account != null && (account.getAccount_no()==account_no) &&account.getBalance()>amount) {
		if (amount< 10000) {
		account.setBalance(account.getBalance()-amount);
		
		entityTransaction.begin();
		entityManager.merge(account);
		entityTransaction.commit();
		return account.getBalance();
		} else {
			System.out.println("withdral amount exceed");
		}
	}else
		System.out.println("balance is less than amount or account log fail");
	return 0;
}

 public double deposit(int id ,long account_no, double amount) {
	 Account account=entityManager.find(Account.class, id);
		if(account != null && (account.getAccount_no()==account_no) ) {
			
			account.setBalance(account.getBalance()+amount);
			
			entityTransaction.begin();
			entityManager.merge(account);
			entityTransaction.commit();
			}else
				System.out.println("Account log fail");
		return 0;
 }
 
 public double  getBalace(int id,long account_no) {
	 Account account=entityManager.find(Account.class, id);
	 if((account.getAccount_no()==account_no))
	 return account.getBalance();
	  
	 System.out.println("Account log fail");
	 return 0.0;
	 
}
}
