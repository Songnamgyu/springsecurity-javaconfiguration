package com.poly.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    
	    auth.inMemoryAuthentication()
	   
	      .withUser("noel").password("{noop}noel").roles("ADMIN");
	  }
	
	  @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers(
	                "/webjars/**");
	    }

	  protected void configure(HttpSecurity http) throws Exception {
	        http
	                .csrf().disable()
	                .authorizeRequests()
	                .antMatchers("/", "/main").permitAll()
	                .antMatchers("/member/**").hasRole("USER")
	                .anyRequest().authenticated()
	                .and()
	                .formLogin()
	                .and()
	                .logout();
	    }
	  
//	    @Bean
//	    public PasswordEncoder encoder() {
//	        return new BCryptPasswordEncoder();
//	    }
	
}
