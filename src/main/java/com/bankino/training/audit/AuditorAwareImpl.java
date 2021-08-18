package com.bankino.training.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
@Override
public Optional<String> getCurrentAuditor() {
	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	
	if (authentication == null) {
		return Optional.of("null");
		//TODO for insert in log table call this method for authentication again but Authentication is null .
	}
	return Optional.of(((UserDetails) authentication.getPrincipal()).getUsername());
}
}

