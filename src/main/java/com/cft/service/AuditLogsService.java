package com.cft.service;

import com.cft.model.AuditLogs;

public interface AuditLogsService {

	AuditLogs getUserDetail(AuditLogs user);

	AuditLogs updateLoggedInStatus(AuditLogs auditLogs);

}
