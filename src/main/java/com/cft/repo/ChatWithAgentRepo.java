package com.cft.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cft.model.ChatWithAgent;

@Repository
public interface ChatWithAgentRepo extends JpaRepository<ChatWithAgent, Long>{

	List<ChatWithAgent> findByTokenOrderByChatIdDesc(Long token);

	List<ChatWithAgent> findByShipmentIdOrderByChatIdDesc(String shipmentId);

	Long countByShipmentIdAndStatus(String shipmentId, int i);

	List<ChatWithAgent> findByShipmentIdAndStatusOrderByChatIdDesc(String shipmentId, int i);

	   int countByShipmentIdAndReadStatusAndStatus(String shipmentId, int i, int j);

	@Modifying
	@Transactional
	@Query(value="UPDATE `agent_to_customer` SET `read_status`=1 WHERE  `to_email`=?1 AND  `shipment_id`=?2  AND STATUS=2",nativeQuery=true)
int updateReadStatus(String email, String shipmentId);

	@Modifying
	@Transactional
	@Query(value="UPDATE `agent_to_customer` SET `tokenTimeout`=2 WHERE  `shipment_id`=?1 ",nativeQuery=true)
	int updateShipmentStatus(String shipmentId);

	
	

	
}
