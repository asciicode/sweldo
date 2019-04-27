package com.atzkarl.core.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.atzkarl.framework.base.spring.data.AuditorAwareBean;

@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig {
	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareBean();
	}

//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//			EntityManagerFactoryBuilder builder, DataSource dataSource) {
//		return builder.dataSource(dataSource).packages("com.atzkarl.**.entity").build();
//	}

}
