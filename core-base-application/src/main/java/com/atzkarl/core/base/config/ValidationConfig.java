package com.atzkarl.core.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.atzkarl.framework.base.validation.ValidationService;
import com.atzkarl.framework.base.validation.ValidationServiceImpl;

@Configuration
public class ValidationConfig {

	// TODO allen pls check : Explicit validator configuration
	// https://stackoverflow.com/questions/12676299/spring-3-1-autowiring-does-not-work-inside-custom-constraint-validator
	@Bean
	ValidationService validationService(ResourcePatternResolver resourcePatternResolver) {
		LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
//		validatorFactoryBean.setMappingLocations(
//				resourcePatternResolver.getResources("classpath:com/atzkarl/framework/base/validator/constraints.xml"));
		ValidationServiceImpl validation = new ValidationServiceImpl();
		validation.setValidatorFactory(validatorFactoryBean);
		return validation;
	}
}
