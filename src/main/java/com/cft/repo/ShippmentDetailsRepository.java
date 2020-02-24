package com.cft.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cft.model.ShippmentDetails;

@Repository
public interface ShippmentDetailsRepository extends JpaRepository<ShippmentDetails, Long> {

	@Query(value="SELECT * FROM shipment_details WHERE shipment_id=?1 AND bill_no=?2 AND reciever_id=(SELECT id FROM users WHERE email=?3)",nativeQuery=true)
	ShippmentDetails getDetailsByShipmentNumberAndEmail(String shipmentId, String billNo, String email);


	@Query(value="SELECT * FROM shipment_details WHERE shipment_id=?1 AND reciever_id=(SELECT id FROM users WHERE email=?2)",nativeQuery=true)
	ShippmentDetails getDetailsByShipmentNumberAndEmail(String shipmentId, String email);


	ShippmentDetails findByShipmentId(String shipmenId);


	@Query(value="SELECT * FROM `shipment_details` INNER JOIN `shipment_invite_emails` ON (`shipment_details`.`id` = `shipment_invite_emails`.`shipment_id`) WHERE  `shipment_invite_emails`.`email`=?1",nativeQuery=true)
	List<ShippmentDetails> getRecords(String email);
	
	
	@Query(value="SELECT shipment_status_air FROM `shipment_status_details` WHERE mode_2=?1",nativeQuery=true)
	String getShipmentStatusOfMode2(int status);
	
	@Query(value="SELECT shipment_status FROM `shipment_status_details` WHERE mode_1=?1",nativeQuery=true)
	String getShipmentStatusOfMode1(int status);

	@Query(value="SELECT COUNT(*) FROM `shipment_details` INNER JOIN `shipment_invite_emails` ON (`shipment_details`.`id` = `shipment_invite_emails`.`shipment_id`) WHERE  `shipment_invite_emails`.`email`=?1",nativeQuery=true)
	int getCount(String email);
	
	

	





	//@Query(value="SELECT * FROM shipment_details INNER JOIN`shipment_status` ON shipment_details.`shipment_status`=shipment_status.`id` WHERE shipment_id=?1 AND bill_no=?2 AND reciever_id=(SELECT id FROM users WHERE email=?3)",nativeQuery=true)


	/*@Query(value="SELECT * FROM shipment_details WHERE shipment_id=?1 AND bill_no=?2 AND reciever_id=(SELECT id FROM users WHERE email=?3)",nativeQuery=true)
List<ShippmentDetails> getDetailsByShipmentNumberAndEmail(String shipmentId, String billNo, String email);
	 */




}
