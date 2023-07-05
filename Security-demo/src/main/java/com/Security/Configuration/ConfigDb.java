package com.Security.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ConfigDb {

	private final CustomFilter customFilter;
	private final UserDetailsServiceImpl userDetailsServiceImpl;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		System.out.println("inside db filterchain");
		DefaultSecurityFilterChain filterChain = httpSecurity.csrf(demo -> demo.disable())
				.authorizeHttpRequests(request -> {

					// request.requestMatchers(HttpMethod.POST, "/authenticate").permitAll();

					request.requestMatchers(HttpMethod.POST, "/addStudent").authenticated();
					request.requestMatchers(HttpMethod.GET, "/demo").authenticated();
					request.requestMatchers(HttpMethod.POST, "/register").permitAll();
					request.requestMatchers(HttpMethod.GET, "/test").permitAll().anyRequest().authenticated();
				}).httpBasic(Customizer.withDefaults()).authenticationProvider(authenticationProvider())
				.addFilterBefore(customFilter, BasicAuthenticationFilter.class).build();

		filterChain.getFilters().stream().forEach(System.out::println);
		return filterChain;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationProvider authenticationProvider() {
		System.out.println("inside auth provider");
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsServiceImpl);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		System.out.println("end of auth provider");
		return daoAuthenticationProvider;
	}

	@Bean
	AuthenticationManager authenticationManager() {
		ProviderManager providerManager = new ProviderManager(authenticationProvider());

		return providerManager;
	}

}
