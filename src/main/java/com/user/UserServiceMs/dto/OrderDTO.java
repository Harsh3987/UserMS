package com.user.UserServiceMs.dto;

import java.util.Date;



public class OrderDTO {

	private Integer orderid;
	private Integer buyerid;
	private Double amount;
	private Date date;
	private String address;
	private String status;
	private ProductsOrderedDTO product;
	
	public ProductsOrderedDTO getProduct() {
		return product;
	}
	public void setProduct(ProductsOrderedDTO product) {
		this.product = product;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(Integer buyerid) {
		this.buyerid = buyerid;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
