package com.example.login_backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.login_backend.services.CustomUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserService userService;

	@Autowired
	private JWTTokenHelper jWTTokenHelper;

	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//in memory authentication with role
		//withUser, password, roles, authority
//		auth.inMemoryAuthentication()
//				.withUser("Yashodha")
//				.password(passwordEncoder().encode("123456789"))
//				.authorities("ADMIN");

		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());

	}
	//for encode password, without -> error
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
//http basic authentication
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		all protected after '/**'
//		antMatchers("/index.html").permitAll()
//		antMatchers("/admin/**").hasRole("ADMIN")
//		antMatchers("/index.html").hasAnyRole("ADMIN","MANAGER")


		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
				.authenticationEntryPoint(authenticationEntryPoint).and()
				.authorizeRequests((request) -> request.antMatchers(
						"/api/v1/auth/login",
								"/api/v1/vws-home"

						)
						.permitAll()
						.antMatchers(HttpMethod.OPTIONS, "/**")
						.permitAll()
						.anyRequest()
						.authenticated())
						.addFilterBefore(new JWTAuthenticationFilter(userService, jWTTokenHelper),
						UsernamePasswordAuthenticationFilter.class);

		http
				.csrf()
				.disable()
				.cors()
				.and()
				.headers()
				.frameOptions()
				.disable();

	}

}
