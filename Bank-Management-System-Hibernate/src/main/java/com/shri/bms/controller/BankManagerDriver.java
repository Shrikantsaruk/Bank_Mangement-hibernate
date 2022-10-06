package com.shri.bms.controller;

import com.shri.bms.dto.Account;
import com.shri.bms.dto.BankManager;
import com.shri.bms.service.BankManagerService;

public class BankManagerDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//   BankManager bankManager=new BankManager();
//   bankManager.setName("Shri");
//   bankManager.setEmail("shri@gmail.com");
//   bankManager.setPassword("shri1234");
		
		Account account=new Account();
		account.setAccount_no(1002003);
		account.setAccount_type("saving");
		account.setBranch("vashi");
		account.setIfsc("121vashi");
		

     BankManagerService bankManagerService= new BankManagerService();
   Account account2=  bankManagerService.approvingCustomer(1, "shri1234", 1, account);
   System.out.println("account no  " + account2.getAccount_no());
	}

}
