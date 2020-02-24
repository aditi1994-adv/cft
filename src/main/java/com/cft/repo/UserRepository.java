package com.cft.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cft.model.Users;


@Repository
public interface UserRepository  extends JpaRepository<Users, Integer>{

	Users findByEmail(String email);

	List<Users> findByCompanyId(int intValue);

	@Query(value="select * from users where id=?1 ",nativeQuery=true)
	Users getDataById(Long senderId);

	

	
}
