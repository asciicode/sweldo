package com.atzkarl.core.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/api/**/v1/**").permitAll();
//		http.authorizeRequests().antMatchers("/api/**/v1/**").authenticated().antMatchers("/public/**").permitAll();
        // http
        // These paths are secured by this SecurityFilterChain
        // .requestMatchers().antMatchers("/user", "/users").and()
        // These from the above are secured by the following way
        // .authorizeRequests().anyRequest().authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(null);
    }
}
