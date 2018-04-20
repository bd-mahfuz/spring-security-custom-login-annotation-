package com.spring_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Mahfuz").password("123").roles("USER");
		auth.inMemoryAuthentication().withUser("hafiz").password("12345").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/author").access("permitAll")
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/user/**").access("hasRole('ROLE_USER')")
		.and().formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/author")
			.permitAll()	
		.and().csrf();
	}

	
}
