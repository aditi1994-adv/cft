package com.cft.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cft.model.ShipmentInviteEmail;


@Repository
public interface ShipmentInviteRepo  extends JpaRepository<ShipmentInviteEmail, Long>{

	List<ShipmentInviteEmail> findByEmail(String email);
	
	
	
}
