package com.shri.bms.controller;

import com.shri.bms.dto.CustomerRequested;
import com.shri.bms.service.CustomerReqService;

public class CustomerDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerRequested customerRequested=new CustomerRequested();
		customerRequested.setName("adam");
		customerRequested.setAddress("vashi");
		customerRequested.setDob("07/09/1998");
		customerRequested.setEmail("adam@gmail.com");
		customerRequested.setPan("12ABS34");
		
		CustomerReqService customerReqService=new CustomerReqService();
		customerReqService.saveBankCustomerReq(customerRequested);
	}

}
