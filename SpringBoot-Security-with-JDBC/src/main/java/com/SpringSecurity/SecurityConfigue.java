package com.SpringSecurity;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfigue extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	
	DataSource datasource;
	
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	//**** for Authentication JDBC
	auth.jdbcAuthentication()
 //***** embedded DataSourec to Spring Boot with create Schema.sql and Data.sql for LOGIN, and Created User&Password Automatic 
	.dataSource(datasource)
	// for retrieve username & password from users table
	.usersByUsernameQuery("select username, password, enabled from users where username=?") 
	// for retrieve username & authority from users table  authorities
	.authoritiesByUsernameQuery("select username, authority from authorities  where username=?");
	
//****** for create schema by spring boot  by using Login 	
//	.withDefaultSchema()  
//	
//	.withUser(User.withUsername("rabia")
//			.password("123")
//			.roles("userSecurity"))
//	.withUser(User.withUsername("foo")
//	      			.password("foo")
//	    			.roles("ADMIN"));
}
 
@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/user").hasRole("USER")
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/").permitAll()
		.and().formLogin();
	}

@Bean
public PasswordEncoder getPasswordEncoder() {
	return NoOpPasswordEncoder.getInstance();
}
}