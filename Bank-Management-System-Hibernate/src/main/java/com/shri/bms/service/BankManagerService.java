package com.shri.bms.service;


import com.shri.bms.dao.BankManagerCrud;
import com.shri.bms.dto.Account;
import com.shri.bms.dto.BankManager;

public class BankManagerService {

		BankManagerCrud bankManagerCrud=new BankManagerCrud();
		public BankManager saveBankManager(BankManager bankManager) {
			
			return bankManagerCrud.saveBankManager(bankManager);
		}
		public BankManager updateBankManager(BankManager bankManager2,int id) {
			
			return bankManagerCrud.updateBankManager(bankManager2, id);
		}
		public BankManager deleteBankManager(int id) {
			
			return bankManagerCrud.deleteBankManager(id);
		}
		public BankManager getById(int id) {
			
			return bankManagerCrud.getById(id);
		}
		
		public Account approvingCustomer(int id,String password, int cid,Account accont) {
			
			return bankManagerCrud.approvingCustomer(id, password, cid, accont);
		}
		
		}

		


