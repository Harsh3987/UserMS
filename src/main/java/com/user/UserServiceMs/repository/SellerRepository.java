package com.user.UserServiceMs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.UserServiceMs.entity.SellerEntity;
@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Integer>{
	
	List<SellerEntity> getBysEmail(String sEmail);
}
