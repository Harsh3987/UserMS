package com.user.UserServiceMs.dto;

public class BuyerLoginDTO {
	
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BuyerLoginDTO() {
		super();
	}
	@Override
	public String toString() {
		return "BuyerLoginDTO [BuyerEmail=" + email + ", password=" + password + "]";
	}
}
