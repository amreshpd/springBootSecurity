package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	/*auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").authorities("CUSTOMER");
	auth.inMemoryAuthentication().withUser("mahesh").password("{noop}hyd").authorities("MANAGER");
	
		// created inMemoryDb (Ram Level) and uses it Authentication Provider
		auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("mahesh").password("{noop}hyd").roles("MANAGER");
		*/
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("raja").
		password("$2a$10$fGFhgqVJbJxYbL.jNiDuC.dN4hgBSiaDJjE3rCF8vEAYMbx2jonpa").roles("CUSTOMER");
		
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("raja").
		password("$2a$10$rbcwUBlAk/e0wjXNbKrKQe5PtmwTureA8ctbM7rlfRT2z47hCpKAC").roles("MANAGER");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/").permitAll()  // NOT Authorization and not authentication
		.antMatchers("/offers").authenticated() //only authentication
		.antMatchers("/balance").hasAnyRole("CUSTOMER","MANAGER") //authentication+authorization
		.antMatchers("/loanApprove").hasRole("MANAGER")
		.anyRequest().authenticated()
		
		//specify authentication mode
	//	.and().httpBasic()
		.and().formLogin()
		//48 hours store the password
		.and().rememberMe()
	//	.and().logout()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
	
		
		//for Exception Handling
		.and().exceptionHandling().accessDeniedPage("/denied")
	   .and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
	}
	
}
