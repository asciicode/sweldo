package com.atzkarl.core.base.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.atzkarl.framework.base.dozer.spring.DozerBeanMapperFactoryBean;

@Configuration
public class DozerConfig {
    @Bean(initMethod = "init")
    public DozerBeanMapperFactoryBean dozerMapper(ResourcePatternResolver resourcePatternResolver) throws IOException {
        DozerBeanMapperFactoryBean factoryBean = new DozerBeanMapperFactoryBean();
        // factoryBean.setMappingFiles(
        // resourcePatternResolver.getResources("classpath:com/atzkarl/framework/base/dozer/dozer.xml"));
        return factoryBean;
    }
}
