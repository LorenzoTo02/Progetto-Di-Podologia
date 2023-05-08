package com.lorenzoclarissa.podology.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests()
				.requestMatchers("/**", "/api/**").hasRole("ADMIN")
				.anyRequest().permitAll()
				.and()			
				.formLogin()
				.loginPage("/login")
				.and()
				.csrf().disable();

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.builder()
			 	.username("ADMIN")
			 	.password("mucca")
			 	.roles("ADMIN")
			 	.build();
		return new InMemoryUserDetailsManager(user);
	}
	
}
