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
public class SecurityConfig {

	private static final String[] SECURED_ADMIN = { 
			"/users/all",
			"/users/{id}",
			"/change_role/{id_user}/{role}" ,
			"/users/deleteUser/{id}"
			};
	
	private static final String[] SECURED_HR_AND_USER = { 
			"/interviews/search_by/{title}",
			"/interviews/paginated_interviews"
			};
	
	private static final String[] SECURED_HR = { 
			"/interviews/show_interview_rh/{id}",
			"/interviews/addInterview",
			"/interviews/editInterview/{id}",
			"/interviews/deleteInterview/{id}",
			"/skills/**",
			"/interviews_skills/**",
			"/tests/**"
			};
	
	private static final String[] SECURED_USER = { 
			"/users/photo", 
			"/users/resume",
			"/users/update",
			"/userskills/**",
			"/current_user/info",
			"/userskills/**",
			"/userskills/add_by/**",
			"/userskills/delete_by/**",
			"/userinterviews/user_join_interview/{id_interview}",
			"/userinterviews/user_interviews",
			"/interviews/show_interview_user/{id}"};

	private static final String[] UN_SECURED_URLs = {
			"/auth/login", "/auth/signup" };

	@Autowired
	private JWTAuthenticationFilter authenticationFilter;

	@Autowired
	private UsersDetailsService userDetailsService;

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
					.requestMatchers(SECURED_USER).hasAuthority("user").requestMatchers(SECURED_HR_AND_USER).hasAnyAuthority("hr","user")
					.requestMatchers(SECURED_HR).hasAuthority("hr").anyRequest().authenticated().and()
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