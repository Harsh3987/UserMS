package com.user.UserServiceMs.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.UserServiceMs.dto.BuyerDTO;
import com.user.UserServiceMs.dto.BuyerLoginDTO;
import com.user.UserServiceMs.dto.CartDTO;
import com.user.UserServiceMs.dto.SellerDTO;
import com.user.UserServiceMs.dto.SellerLoginDTO;
import com.user.UserServiceMs.dto.WishlistDTO;
import com.user.UserServiceMs.entity.BuyerEntity;
import com.user.UserServiceMs.entity.CartEntity;
import com.user.UserServiceMs.entity.SellerEntity;
import com.user.UserServiceMs.entity.WishlistEntity;
import com.user.UserServiceMs.repository.BuyerRepository;
import com.user.UserServiceMs.repository.CartRepository;
import com.user.UserServiceMs.repository.SellerRepository;
import com.user.UserServiceMs.repository.WishlistRepository;
import com.user.UserServiceMs.validator.BuyerValidator;
import com.user.UserServiceMs.validator.SellerValidator;

@Service
public class UserServiceMSservice {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BuyerRepository buyerRepo;
	
	@Autowired
	SellerRepository sellerRepo;
	
	@Autowired
	WishlistRepository wishlistRepo;
	
	@Autowired
	CartRepository cartRepo;
	
//	Register Buyer
	public Integer createBuyer(BuyerDTO buyerDTO) throws Exception {
		BuyerValidator.validateBuyer(buyerDTO);
		List<BuyerEntity> buyerList = buyerRepo.findAll();
		for(BuyerEntity be : buyerList) {
			System.out.println(be.getPhoneNumber());
			if(be.getPhoneNumber().equals(buyerDTO.getPhoneNo().substring(4))) {
				System.out.println(buyerDTO.getPhoneNo().substring(4));
				throw new Exception();
			}
		}
		buyerDTO.setPhoneNo(buyerDTO.getPhoneNo().substring(4));
		logger.info("Creation request for Buyer {}", buyerDTO);
		BuyerEntity buyer = buyerDTO.createEntity();
		
		return buyerRepo.save(buyer).getBuyerId();
	}
 

//	login Buyer
	public boolean buyerLogin(BuyerLoginDTO buyerLoginDTO) throws Exception {
		BuyerValidator.validateBuyerLogin(buyerLoginDTO);
		logger.info("Login request for buyer {} with password {}", buyerLoginDTO.getEmail(),buyerLoginDTO.getPassword());
		List<BuyerEntity> buyerList = buyerRepo.getByEmail(buyerLoginDTO.getEmail());
		if (!buyerList.isEmpty()) {
			for(BuyerEntity buyerEntity:buyerList) {
			
				if (buyerEntity.getPassword().equals(buyerLoginDTO.getPassword())) {
					return true;
				}
			}
		}

		return false;
	}
	//find buyer by id
	public boolean findBuyerId(Integer buyerId)
	{
		logger.info("find request for buyer {} with buyerId{}", buyerId);
		Optional<BuyerEntity> buyerEntity =buyerRepo.findById(buyerId);
		if (buyerEntity.isPresent())
		{
			return true;
		}
		return false;
	}
	
//	Register seller
	public Integer createSeller(SellerDTO sellerDTO) throws Exception {
		SellerValidator.validateSeller(sellerDTO);
		sellerDTO.setsPhoneNo(sellerDTO.getsPhoneNo().substring(4));
		logger.info("Creation request for seller {}", sellerDTO);
		sellerDTO.setsIsActive(1);
		SellerEntity seller = sellerDTO.createEntity();
		
		return sellerRepo.save(seller).getSellerId();
	}
	
//	login Seller
	public boolean sellerLogin(SellerLoginDTO sellerLoginDTO) throws Exception {
		SellerValidator.validateSellerLogin(sellerLoginDTO);
		logger.info("Login request for seller {} with password {}", sellerLoginDTO.getsEmail(),sellerLoginDTO.getsPassword());
		List<SellerEntity> sellerList = sellerRepo.getBysEmail(sellerLoginDTO.getsEmail());
		if (!sellerList.isEmpty()) {
			for(SellerEntity sellerEntity:sellerList) {
				if(sellerEntity.getIsActive()==0) {
					throw new Exception("Seller.DEACTIVATED");
				}
				if (sellerEntity.getsPassword().equals(sellerLoginDTO.getsPassword())) {
					return true;
				}
			}
		}

		return false;
	}
	//find seller by id
		public boolean findSellerId(Integer sellerId)
		{
			logger.info("find request for seller {} with sellerId{}", sellerId);
			Optional<SellerEntity> sellerEntity =sellerRepo.findById(sellerId);
			if (sellerEntity.isPresent())
			{
				return true;
			}
			return false;
		}
		
	// deactivate seller
		public boolean deactivateSeller(Integer sellerId) {
			logger.info("deactivate request for seller {} with sellerId{}", sellerId);
			Optional<SellerEntity> sellerEntity =sellerRepo.findById(sellerId);
			if (sellerEntity.isPresent())
			{
				SellerEntity seller=sellerEntity.get();
				seller.setIsActive(0);
				sellerRepo.save(seller);
				return true;
				
			}
			return false;
			
		}
	// activate seller
		public boolean activateSeller(SellerLoginDTO sellerLoginDTO) {
			logger.info("activate request for seller {} with email{}", sellerLoginDTO.getsEmail());
			List<SellerEntity> sellerEntities =sellerRepo.getBysEmail(sellerLoginDTO.getsEmail());
			if(!sellerEntities.isEmpty()) {
				for(SellerEntity sellerEntity:sellerEntities) {
					if (sellerEntity.getsPassword().equals(sellerLoginDTO.getsPassword())) {
						sellerEntity.setIsActive(1);
						sellerRepo.save(sellerEntity);
						return true;	
					}
				}
				
			}
			return false;
		}
		
		public boolean deactivateBuyer(Integer buyerId) {
			Optional<BuyerEntity> buyerEntity =buyerRepo.findById(buyerId);
			if (buyerEntity.isPresent())
			{
				BuyerEntity buyer=buyerEntity.get();
				buyer.setIsActive(0);
				buyerRepo.save(buyer);
				return true;
				
			}
			return false;
			
		}
		
		public boolean activateBuyer(BuyerLoginDTO buyerLoginDTO) {
			List<BuyerEntity> buyerEntities =buyerRepo.getByEmail(buyerLoginDTO.getEmail());
			if(!buyerEntities.isEmpty()) {
				for(BuyerEntity buyerEntity:buyerEntities) {
					if (buyerEntity.getPassword().equals(buyerLoginDTO.getPassword())) {
						buyerEntity.setIsActive(1);
						buyerRepo.save(buyerEntity);
						return true;
					}
				}
				
			}
			return false;
		}
 	
	// add product to wishlist
		public Integer addProductToWishlist(WishlistDTO wishlistDTO) {
			WishlistEntity wlistEntity = wishlistDTO.createEntity();
			return wishlistRepo.save(wlistEntity).getProdId();
		}
		
	// remove product from wishlist
		public Boolean removeProductFromWishlist(Integer buyerId, Integer productId) {
			List<WishlistEntity> wishlist = wishlistRepo.findAll();
			for(WishlistEntity wl : wishlist) {
				if((wl.getBuyerId() == buyerId) && (wl.getProdId() == productId)) {
					wishlistRepo.delete(wl);
					return true;
				}
			}
			return false;
		}
		
		public Integer addProductToCart(CartDTO cartDTO) {
			CartEntity cartEntity = cartDTO.createEntity();
			return cartRepo.save(cartEntity).getProductId();
		}
		
		public Boolean removeProductFromCart(Integer buyerId,Integer productId) {
			List<CartEntity> cart = cartRepo.findAll();
			for(CartEntity ce:cart) {
				if((ce.getBuyerId() == buyerId) && (ce.getProductId() == productId)) {
					cartRepo.delete(ce);
					return true;
				}
			}
			return false;
		}
}
