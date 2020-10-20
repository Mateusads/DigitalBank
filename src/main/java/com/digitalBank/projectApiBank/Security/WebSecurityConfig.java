package com.digitalBank.projectApiBank.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/client/save");
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/client").permitAll()
				.antMatchers(HttpMethod.POST, "/save").permitAll().anyRequest().authenticated()
				.and()
				.formLogin();

//		.antMatchers("/client").permitAll()
		// .and()
//			.antMatcher("/client/save/address")
//			// filtra requisições de login
//			.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
//	                UsernamePasswordAuthenticationFilter.class)
//			
//			// filtra outras requisições para verificar a presença do JWT no header
//			.addFilterBefore(new JWTAuthenticationFilter(),
//	                UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// cria uma conta default
		auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
	}

}
