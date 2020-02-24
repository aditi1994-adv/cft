package com.cft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cft.model.AdminNotification;

@Repository
public interface NotificationTableRepository extends JpaRepository<AdminNotification, Long>{
	

}
