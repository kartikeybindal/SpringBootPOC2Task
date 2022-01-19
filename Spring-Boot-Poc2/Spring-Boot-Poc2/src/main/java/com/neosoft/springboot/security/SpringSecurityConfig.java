package com.neosoft.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		
		/*
		 * http.authorizeRequests().antMatchers("/myhome","/login","/register").
		 * permitAll() .anyRequest().authenticated().and().httpBasic();
		 */

	http
			.csrf().disable() ///use of add new Entries
	.authorizeRequests()
	
			 .antMatchers("/students").hasRole("NORMAL")
			 .antMatchers("/projects","/students/{studentId}/projects","/projects/{id}").hasRole("ADMIN")
	.anyRequest().authenticated().and().httpBasic();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("kartikey").password(this.passwordEncoder().encode("kartikey@90500")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("admin").password(this.passwordEncoder().encode("admin@123")).roles("ADMIN");
	}
	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return
	 * NoOpPasswordEncoder.getInstance();
	 * 
	 * }
	 */
	//Role-high level overview ->normal:read
	//Authority-permission->
	//admin->read write update
	
	 
	
		
		 @Bean 
		 public PasswordEncoder passwordEncoder()
		 {
		  
		 return new BCryptPasswordEncoder(10);
		 
		  }
		 

	
	

}