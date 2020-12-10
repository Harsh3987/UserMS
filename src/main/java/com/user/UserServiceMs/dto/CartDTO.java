package com.user.UserServiceMs.dto;


import com.user.UserServiceMs.entity.CartEntity;

public class CartDTO {

	private Integer buyerId;
	private Integer productId;
	private Integer quantity;
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartDTO [quantity=" + quantity + "]";
		
	}
	public static CartDTO valueOf(CartEntity cartEntity) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setBuyerId(cartEntity.getBuyerId());
		cartDTO.setProductId(cartEntity.getProductId());
		cartDTO.setQuantity(cartEntity.getQuantity());
		return cartDTO;

	}
	public CartEntity createEntity() {
		CartEntity cartEntity = new CartEntity();
		cartEntity.setQuantity(this.getQuantity());
		cartEntity.setBuyerId(this.getBuyerId());
		cartEntity.setProductId(this.getProductId());
		return cartEntity;
	}

}

