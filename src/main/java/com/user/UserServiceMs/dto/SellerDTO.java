package com.user.UserServiceMs.dto;


import com.user.UserServiceMs.entity.SellerEntity;

public class SellerDTO {
	
	private Integer sellerId;
	private String sName;
	private String sEmail;
	private String sPhoneNo;
	private String sPassword;
	private Integer sIsActive;
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
	public String getsPhoneNo() {
		return sPhoneNo;
	}
	public void setsPhoneNo(String sPhoneNo) {
		this.sPhoneNo = sPhoneNo;
	}
	public String getsPassword() {
		return sPassword;
	}
	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}
	public Integer getsIsActive() {
		return sIsActive;
	}
	public void setsIsActive(Integer sIsActive) {
		this.sIsActive = sIsActive;
	}
	
	@Override
	public String toString() {
		return "SellerDTO [ name=" + sName + ",  Email=" + sEmail + ", PhoneNumber=" + sPhoneNo
				+ ", Password=" + sPassword + "]";
	}

		// Converts Entity into DTO
		public static SellerDTO valueOf(SellerEntity sellerEntity) {
			SellerDTO sellerDTO = new SellerDTO();
			sellerDTO.setSellerId(sellerEntity.getSellerId());
			sellerDTO.setsEmail(sellerEntity.getsEmail());
			sellerDTO.setsIsActive(sellerEntity.getIsActive());
			sellerDTO.setsName(sellerEntity.getsName());
			sellerDTO.setsPassword(sellerEntity.getsPassword());
			sellerDTO.setsPhoneNo(sellerEntity.getsPhoneNumber());
			
			
			
			
			
			return sellerDTO;
		}

		// Converts DTO into Entity
		public SellerEntity createEntity() {
			SellerEntity sellerEntity=new SellerEntity();
			sellerEntity.setIsActive(this.getsIsActive());
			sellerEntity.setsEmail(this.getsEmail());
			sellerEntity.setsName(this.getsName());
			sellerEntity.setsPassword(this.getsPassword());
			sellerEntity.setsPhoneNumber(this.getsPhoneNo());
		
			
			return sellerEntity;
		}
	
	
	
}
