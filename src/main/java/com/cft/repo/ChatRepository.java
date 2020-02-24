package com.cft.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cft.model.Chat;
import com.cft.util.Number;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

	List<Chat> findByToken(Long token);

	List<Chat> findByTokenOrderByChatIdDesc(Long token);

	List<Chat> findByEmail(String email);

	List<Chat> findByTokenOrderByChatIdAsc(Long token);

	long countByTokenAndStatus(Long token, int i);

	List<Chat> findByTokenAndStatusOrderByChatIdDesc(Long token, int i);

	@Modifying
	@Transactional
	@Query(value="UPDATE chat  SET tokenTimeout=0 WHERE token=?1",nativeQuery=true)
int  updatetokenStatus(Long token);

	List<Chat> findByTokenAndTokenTimeoutOrderByChatIdDesc(Long token, int i);

	List<Chat> findByTokenAndTokenTimeoutAndStatusOrderByChatIdDesc(Long token, int i, int j);


	

//	List findBySenderId(int i);

/*	List findBySenderIdOrderByChatIdDesc(int i);

	List findBySenderId(int i);*/
	
	

	

}