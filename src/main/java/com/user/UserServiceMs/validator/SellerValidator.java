package com.user.UserServiceMs.validator;

import com.user.UserServiceMs.dto.BuyerDTO;
import com.user.UserServiceMs.dto.SellerDTO;
import com.user.UserServiceMs.dto.SellerLoginDTO;

public class SellerValidator {
	public static void validateSeller(SellerDTO sellerDTO) throws Exception{
		
		if(!validateName(sellerDTO.getsName())) {
			throw new Exception("SellerValidator.INVALID_SELLERNAME");
		}
		if(!validateEmail(sellerDTO.getsEmail())) {
			throw new Exception("SellerValidator.INVALID_SELLEREMAIL");
		}
		if(!validatePhoneNo(sellerDTO.getsPhoneNo())) {
			throw new Exception("SellerValidator.INVALID_SELLERPHONENO");
		}
		if(!validatePassword(sellerDTO.getsPassword())) {
			throw new Exception("SellerValidator.INVALID_SELLERPASSWORD");
		}
		
	}
	
     public static void validateSellerLogin(SellerLoginDTO sellerLoginDTO) throws Exception{
		
		if(!validateEmail(sellerLoginDTO.getsEmail())) {
			throw new Exception("SellerValidator.INVALID_SELLEREMAIL");
		}
		if(!validatePassword(sellerLoginDTO.getsPassword())) {
			throw new Exception("SellerValidator.INVALID_SELLERPASSWORD");
		}
		
	}

	public static Boolean validateName(String sellerName) {
		String regex="^[-a-zA-Z]+(\\s+[-a-zA-Z]+)*$";
			if(sellerName.matches(regex)) {
				return true;
			}
		
		return false;
	}
	public static Boolean validateEmail(String sellerEmail) {
		
		String regex="[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+";
		if(sellerEmail.matches(regex)) {
			return true;
		}
		return false;
	}
    public static Boolean validatePhoneNo(String sellerPhoneNo) {
    	
		if(sellerPhoneNo.substring(0, 4).equals("+91-")) {
			
			String regex="[0-9]{10}";
			if(sellerPhoneNo.substring(4).matches(regex)) {
				
				return true;
			}
		}
		
		
		return false;
	}
    public static Boolean validatePassword(String sellerPassword) {
		
		String regex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&%*$]).{7,20}$";
		if(sellerPassword.matches(regex)) {
			return true;
		}
		return false;
	}
}
