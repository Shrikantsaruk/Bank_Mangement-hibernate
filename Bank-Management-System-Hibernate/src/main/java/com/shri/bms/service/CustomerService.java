package com.shri.bms.service;

import com.shri.bms.dao.CustomerCrud;
import com.shri.bms.dto.Account;
import com.shri.bms.dto.Customer;

public class CustomerService {
		CustomerCrud crud=new CustomerCrud();
		public Customer saveCustomer(Customer customer,Account account) {
			
			return crud.saveCustomer(customer, account);
		}
		public Customer updateCustomer(Customer customer2,int id) {
			
			return crud.updateCustomer(customer2, id);
		}
		public Customer deleteCustomer(int id) {
			
			return crud.deleteCustomer(id);
		}
		public Customer getById(int id) {
			return crud.getById(id);
		}

		}



