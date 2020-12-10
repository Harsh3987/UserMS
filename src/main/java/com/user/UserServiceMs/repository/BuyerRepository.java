package com.user.UserServiceMs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.UserServiceMs.entity.BuyerEntity;
@Repository
public interface BuyerRepository extends JpaRepository<BuyerEntity, Integer>{

	List<BuyerEntity> getByEmail(String email);
	
}
