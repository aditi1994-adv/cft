package com.cft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cft.model.Advertisement;

@Repository
public interface AdvertisementRepo   extends JpaRepository<Advertisement, Integer>{

}
