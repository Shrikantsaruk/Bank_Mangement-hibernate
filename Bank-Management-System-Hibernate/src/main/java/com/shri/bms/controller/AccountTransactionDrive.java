package com.shri.bms.controller;

import com.shri.bms.service.AccountService;

public class AccountTransactionDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountService accountService=new AccountService();
		accountService.deposit(1, 1002003, 5000.0);
	}

}
