package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private DataSource ds;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.jdbcAuthentication().dataSource(ds).passwordEncoder(new BCryptPasswordEncoder())
	.usersByUsernameQuery("SELECT UNAME,PWD,STATUS from USERS where UName=?") //for authentication
	.authoritiesByUsernameQuery("select uname,role from user_roles where uname=?"); //for authorization
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/").permitAll()  // NOT Authorization and not authentication
		.antMatchers("/offers").authenticated() //only authentication
		.antMatchers("/balance").hasAnyAuthority("CUSTOMER","MANAGER") //authentication+authorization
		.antMatchers("/loanApprove").hasAuthority("MANAGER")
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
