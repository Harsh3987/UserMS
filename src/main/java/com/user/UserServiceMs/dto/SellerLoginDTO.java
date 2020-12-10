package com.user.UserServiceMs.dto;

public class SellerLoginDTO {


	private String sEmail;
	private String sPassword;
	
	
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getsPassword() {
		return sPassword;
	}
	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}
	public SellerLoginDTO() {
		super();
	}
	@Override
	public String toString() {
		return "SellerLoginDTO [SellerEmail=" + sEmail + ", password=" + sPassword + "]";
	}
}
