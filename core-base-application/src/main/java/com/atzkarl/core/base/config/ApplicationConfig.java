package com.atzkarl.core.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.atzkarl.framework.base.rest.controller.GlobalControllerExceptionHandler;

@Configuration
@Import({ GlobalControllerExceptionHandler.class })
public class ApplicationConfig {

}
