package com.atzkarl.framework.base.spring.data;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareBean implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return Optional.of("allen");
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