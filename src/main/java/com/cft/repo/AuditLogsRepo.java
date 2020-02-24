package com.cft.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cft.model.AuditLogs;

@Repository
public interface AuditLogsRepo  extends JpaRepository<AuditLogs, Long>{

	AuditLogs findByEmailAndPasswordAndLoggedInStatus(String email, String password, int loggedInStatus);

	@Modifying
	@Transactional
	@Query(value="UPDATE audit_logs  SET logged_in_status=?1 WHERE audit_logs=?2",nativeQuery=true)
	int updateLoggedInStatus(int loggedInStatus, Long auditLogs);

	

}
