package com.cft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cft.model.ShipmentNotification;

@Repository
public interface ShipmentNotificationRepo extends JpaRepository<ShipmentNotification, Integer> {

}
