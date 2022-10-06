package com.shri.bms.controller;

import com.shri.bms.dto.Admin;
import com.shri.bms.service.AdminService;

public class AdminDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Admin admin=new Admin();
//		admin.setName("nilesh");
//		admin.setEmail("nilesh@gmail.com");
//		admin.setPassword("1234");
    AdminService adminService=new AdminService();
	adminService.approvingBankManager(1, "1234", 1);
		
	
	}

}
