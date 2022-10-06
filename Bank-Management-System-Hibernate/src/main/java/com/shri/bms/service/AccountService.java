package com.shri.bms.service;

import com.shri.bms.dao.AccountOperation;

public class AccountService {
	
	AccountOperation accountOperation=new AccountOperation();
	public double withdral(int id,long account_no,double amount) {
		
		return accountOperation.withdral(id, account_no ,amount);
	}

	 public double deposit(int id ,long account_no ,double amount) {
		
			return accountOperation.deposit(id, account_no ,amount);
	 }
	 
	 public double  getBalace(int id,long account_no) {
		
		 return accountOperation.getBalace(id,account_no);
	}
}
