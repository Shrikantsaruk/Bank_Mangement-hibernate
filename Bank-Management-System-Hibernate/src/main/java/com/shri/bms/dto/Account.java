package com.shri.bms.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private long account_no;
private String account_type;
private double balance=0.0;
private String ifsc;
private String bank_name="SBI";
private String branch;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public long getAccount_no() {
	return account_no;
}
public void setAccount_no(long account_no) {
	this.account_no = account_no;
}
public String getAccount_type() {
	return account_type;
}
public void setAccount_type(String account_type) {
	this.account_type = account_type;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public String getIfsc() {
	return ifsc;
}
public void setIfsc(String ifsc) {
	this.ifsc = ifsc;
}
public String getBank_name() {
	return bank_name;
}
public void setBank_name(String bank_name) {
	this.bank_name = bank_name;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}

}
