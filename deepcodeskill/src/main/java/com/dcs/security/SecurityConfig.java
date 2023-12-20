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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.dcs.jwt.JWTAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private static final String[] SECURED_ADMIN = { 
			"/users/all", "/users/{id}", 
			"/change_role/{id_user}/{role}",
			"/users/deleteUser/{id}" };

	private static final String[] SECURED_HR_AND_USER = { 
			"/users/update",
			"/interviews/search_by/{title}", 
			"/userskills/delete_by/{id_user}/{id_skill}",
			"/interviews/paginated_interviews", 
			"/skills/paginated_skills" };

	private static final String[] SECURED_HR = { 
			"/interviews/show_interview_rh/{id}", 
			"/interviews/addInterview",
			"/interviews/editInterview/{id}", 
			"/interviews/deleteInterview/{id}", 
			"/userskills/qualificate/{id_user}/{id_skill}", 
			"/skills/addSkill",
			"/skills/editSkill/{id}", 
			"/skills/deleteSkill/{id}", 
			"/interviews_skills/**", 
			"/tests/**",
			"/users/user_resume/{id}",
			"/userinterviews/changeState/{id_interview}/{state}", 
			"/userinterviews/changeComment/{id_interview}"};

	private static final String[] SECURED_USER = { 
			"/current_user/info", 
			"/userskills/add_by/{id_skill}",  
			"/userinterviews/user_join_interview/{id_interview}",
			"/userinterviews/user_interviews", 
			"/interviews/show_interview_user/{id}", 
			"/users/my_resume" };

	private static final String[] UN_SECURED_URLs = { "/auth/login", "/auth/signup","/users/photo", "/users/resume" };

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
			return http.cors().and().csrf().disable().authorizeHttpRequests()
					.requestMatchers(UN_SECURED_URLs).permitAll().and().authorizeHttpRequests()
					.requestMatchers(SECURED_ADMIN).hasAuthority("admin")
					.requestMatchers(SECURED_USER).hasAuthority("user")
					.requestMatchers(SECURED_HR_AND_USER).hasAnyAuthority("hr", "user")
					.requestMatchers(SECURED_HR).hasAuthority("hr").anyRequest()
					.authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					.and().authenticationProvider(authenticationProvider())
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
