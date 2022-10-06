package com.shri.bms.service;

import com.shri.bms.dao.CustomerRequestedCrud;
import com.shri.bms.dto.CustomerRequested;

public class CustomerReqService {

	CustomerRequestedCrud crud=new CustomerRequestedCrud();
		public CustomerRequested saveBankCustomerReq(CustomerRequested customer) {
			return crud.saveBankCustomerReq(customer);
		}
	}

