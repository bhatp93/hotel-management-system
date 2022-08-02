package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import javax.persistence.Embeddable;

@Embeddable
public class Account {

	public String password;
	public AccountStatus status;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	
	
}
