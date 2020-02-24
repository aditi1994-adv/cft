package com.cft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cft.model.Admin;

@Repository
public interface AdminRepo  extends JpaRepository<Admin, Long>{

	
	@Query(value="SELECT * FROM `master_users` ORDER BY id  DESC LIMIT 1" ,nativeQuery=true)
	Admin getAdminRecord();

	

}
