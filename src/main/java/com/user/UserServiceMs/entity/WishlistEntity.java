package com.user.UserServiceMs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="wishlist")
@IdClass(WishlistEntity.class)
public class WishlistEntity implements Serializable {
	@Id
	@Column(name="BUYERID",nullable = false)
	private Integer buyerId;
	public Integer getBuyerId() {
		return buyerId;
	}
	@Id
	@Column(name="PRODID",nullable = false)
	private Integer prodId;
	
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	
	}

	

