package com.bankino.training.filters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

@Component
public class AnotherCustomLoggingFilter extends AbstractRequestLoggingFilter {

@Value("${request.logging.shouldLog}")
private boolean shouldLog;

public AnotherCustomLoggingFilter() {
	setIncludeClientInfo(true);
	setIncludeQueryString(true);
	setIncludePayload(true);
	setMaxPayloadLength(10000);
	setIncludeHeaders(true);
	setBeforeMessagePrefix("Request started => ");
	setAfterMessagePrefix("Request ended => ");
}

@Override
protected boolean shouldLog(HttpServletRequest request) {
	return shouldLog;
}

@Override
protected void beforeRequest(HttpServletRequest request, String message) {
	logger.info(message);
}

@Override
protected void afterRequest(HttpServletRequest request, String message) {
	logger.info(message);
}
}
