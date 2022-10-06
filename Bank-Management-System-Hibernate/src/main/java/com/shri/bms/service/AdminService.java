package com.shri.bms.service;
import com.shri.bms.dao.AdminCrud;
import com.shri.bms.dto.Admin;

public class AdminService {

	AdminCrud adminCrud=new AdminCrud();
	public Admin saveAdmin(Admin admin) {
		return adminCrud.saveAdmin(admin);
	}
	
	public Admin updateAdmin(Admin admin2,int id) {
		return adminCrud.updateAdmin(admin2, id);
	}
	
	public Admin deleteAdmin(int id) {
		return adminCrud.deleteAdmin(id);
	}
	
	public Admin getById(int id) {
		return adminCrud.getById(id);
	}
	
	public int approvingBankManager(int id,String password,int bmid) {
		return adminCrud.approvingBankManager(id, password, bmid);
	}
}

