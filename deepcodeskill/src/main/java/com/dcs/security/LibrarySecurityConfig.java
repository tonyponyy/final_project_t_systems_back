package com.dcs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dcs.jwt.JWTAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class LibrarySecurityConfig {

	private static final String[] SECURED_ADMIN = { "/users/all" };

	private static final String[] SECURED_USER = { "/interviews/**","/users/photo", "/users/resume" };

	private static final String[] UN_SECURED_URLs = {
			// "/books/all",
			"/auth/login", "/auth/signup" };

	@Autowired
	private JWTAuthenticationFilter authenticationFilter;

	@Autowired
	private LibraryUserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		var authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		boolean security = true;
		if (security) {
			return http.csrf().disable().authorizeHttpRequests().requestMatchers(UN_SECURED_URLs).permitAll().and()
					.authorizeHttpRequests().requestMatchers(SECURED_ADMIN).hasAuthority("admin")
					.requestMatchers(SECURED_USER).hasAuthority("user").anyRequest().authenticated().and()
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
					.authenticationProvider(authenticationProvider())
					.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class).build();
		} else {
			http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().permitAll())
					.csrf(AbstractHttpConfigurer::disable);
			return http.build();

		}

	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

}