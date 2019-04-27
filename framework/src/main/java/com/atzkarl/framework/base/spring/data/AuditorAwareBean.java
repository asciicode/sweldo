package com.atzkarl.framework.base.spring.data;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareBean implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            return Optional.of(authentication.getName());
        } else {
            return Optional.of("batch");
        }
	}

//	@Override
//	public String getCurrentAuditor() {
//
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//		if (authentication != null) {
//			return authentication.getName();
//		} else {
//			return "batch";
//		}
//	}

}