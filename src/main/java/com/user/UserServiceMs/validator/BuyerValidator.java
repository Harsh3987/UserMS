package com.user.UserServiceMs.validator;

import com.user.UserServiceMs.dto.BuyerDTO;
import com.user.UserServiceMs.dto.BuyerLoginDTO;

public class BuyerValidator {

	public static void validateBuyer(BuyerDTO buyerDTO) throws Exception{
		
		if(!validateName(buyerDTO.getName())) {
			throw new Exception("BuyerValidator.INVALID_BUYERNAME");
		}
		if(!validateEmail(buyerDTO.getEmail())) {
			throw new Exception("BuyerValidator.INVALID_BUYEREMAIL");
		}
		if(!validatePhoneNo(buyerDTO.getPhoneNo())) {
			throw new Exception("BuyerValidator.INVALID_BUYERPHONENO");
		}
		if(!validatePassword(buyerDTO.getPassword())) {
			throw new Exception("BuyerValidator.INVALID_BUYERPASSWORD");
		}
		
	}
	public static void validateBuyerLogin(BuyerLoginDTO buyerLoginDTO) throws Exception{
		
		if(!validateEmail(buyerLoginDTO.getEmail())) {
			throw new Exception("BuyerValidator.INVALID_BUYEREMAIL");
		}
		if(!validatePassword(buyerLoginDTO.getPassword())) {
			throw new Exception("BuyerValidator.INVALID_BUYERPASSWORD");
		}
		
	}
	
	public static Boolean validateName(String buyerName) {
		String regex="^[-a-zA-Z]+(\\s+[-a-zA-Z]+)*$";
			if(buyerName.matches(regex)) {
				return true;
			}
		
		return false;
	}
	public static Boolean validateEmail(String buyerEmail) {
		
		String regex="[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+";
		if(buyerEmail.matches(regex)) {
			return true;
		}
		return false;
	}
    public static Boolean validatePhoneNo(String buyerPhoneNo) {
    	
		if(buyerPhoneNo.substring(0, 4).equals("+91-")) {
			
			String regex="[0-9]{10}";
			if(buyerPhoneNo.substring(4).matches(regex)) {
				
				return true;
			}
		}
		
		
		return false;
	}
    public static Boolean validatePassword(String buyerPassword) {
		
		String regex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&%*$]).{7,20}$";
		if(buyerPassword.matches(regex)) {
			return true;
		}
		return false;
	}
}
