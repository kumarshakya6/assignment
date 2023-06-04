package com.vipin.assignment.config;


import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		//define query to retrieve a user by username
		jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
		// define query to retrieve a authorities/roles by username
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
		return  jdbcUserDetailsManager;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		 
	
		http
		.httpBasic(withDefaults() )
		.authorizeHttpRequests(configurer ->
		
		configurer
		
		
		.requestMatchers(HttpMethod.GET, "/api/contacts").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.GET, "/api/contacts/**").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.POST, "/api/contacts").hasAnyRole("MANAGER", "ADMIN")
		.requestMatchers(HttpMethod.PUT, "/api/contacts").hasRole("MANAGER")
		.requestMatchers(HttpMethod.DELETE, "/api/contacts/**").hasRole("ADMIN")
		
		
		//// 
		.requestMatchers(HttpMethod.GET, "/swagger-ui/index.html").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.GET, "/swagger-ui/swagger-initializer.js").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.GET, "/v3/api-docs/swagger-config").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.GET, "/v3/api-docs").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.GET, "/swagger-ui").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.GET, "/swagger-ui/**").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.GET, "/error").hasRole("EMPLOYEE")
		
		
		

				)
		.csrf(t -> t.disable());
		
		//http.httpBasic( t -> {});
		//http.csrf(t -> {} );
		
		
		return http.build();
	}
}
