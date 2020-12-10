package com.user.UserServiceMs.dto;

import com.user.UserServiceMs.entity.BuyerEntity;

public class BuyerDTO {
	private Integer buyerId;
	private String name;
	private String email;
	private String phoneNo;
	private String password;
	private Integer isPrivileged;
	private Integer rewardPoints;
	private Integer isActive;
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIsPrivileged() {
		return isPrivileged;
	}
	public void setIsPrivileged(Integer isPrivileged) {
		this.isPrivileged = isPrivileged;
	}
	public Integer getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		return "BuyerDTO [phoneNo=" + phoneNo + ", name=" + name + ",  password=" + password + ", RewardPoints=" + rewardPoints
				+ ", IsPrivileged=" + isPrivileged + "]";
	}

		// Converts Entity into DTO
		public static BuyerDTO valueOf(BuyerEntity buyerEntity) {
			BuyerDTO buyerDTO = new BuyerDTO();
			buyerDTO.setBuyerId(buyerEntity.getBuyerId());
			buyerDTO.setEmail(buyerEntity.getEmail());
			buyerDTO.setName(buyerEntity.getName());
			buyerDTO.setPhoneNo(buyerEntity.getPhoneNumber());
			buyerDTO.setRewardPoints(buyerEntity.getRewardPoints());
			buyerDTO.setIsPrivileged(buyerEntity.getIsPrivileged());
			buyerDTO.setIsActive(buyerEntity.getIsActive());
			
			
			
			
			return buyerDTO;
		}

		// Converts DTO into Entity
		public BuyerEntity createEntity() {
			BuyerEntity buyerEntity = new BuyerEntity();
			buyerEntity.setIsActive(this.getIsActive());
			buyerEntity.setRewardPoints(this.getRewardPoints());
			buyerEntity.setName(this.getName());
			buyerEntity.setPhoneNumber(this.getPhoneNo());
			buyerEntity.setEmail(this.getEmail());
			buyerEntity.setPassword(this.getPassword());
			buyerEntity.setIsPrivileged(this.getIsPrivileged());
			return buyerEntity;
		}
	
	
}
