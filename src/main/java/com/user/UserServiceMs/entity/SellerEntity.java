package com.user.UserServiceMs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seller")
public class SellerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SELLERID",nullable = false)
	private Integer sellerId;
	@Column(name="NAME",nullable = false,length = 45)
	private String  sName;
	@Column(name="EMAIL",nullable = false,length = 45)
	private String sEmail;
	@Column(name="PHONENUMBER",nullable = false,length = 45)
	private String sPhoneNumber;
	@Column(name="PASSWORD",nullable = false,length = 45)
    private String sPassword;
	@Column(name="ISACTIVE")
	private Integer isActive;
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getsPhoneNumber() {
		return sPhoneNumber;
	}
	public void setsPhoneNumber(String sPhoneNumber) {
		this.sPhoneNumber = sPhoneNumber;
	}
	public String getsPassword() {
		return sPassword;
	}
	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	
}
