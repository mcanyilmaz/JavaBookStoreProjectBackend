package com.bookApplication2.BookApplication2.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bookApplication2.BookApplication2.config.jwt.AuthEntryPointJwt;
import com.bookApplication2.BookApplication2.config.jwt.AuthTokenFilter;
import com.bookApplication2.BookApplication2.service.UserService;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	UserService userService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests().antMatchers("/api/auth/**").permitAll()
			.antMatchers("/v1/**").permitAll()
			
			//FOR ROLE ADM??N 
			//.antMatchers("/api/test/**").permitAll()
			//.hasAnyAuthority("/admin/**")
			// FOR ROLE ADM??N F??N??SH
			
			.antMatchers("/api/test/**").permitAll()
			.antMatchers("/image/**").permitAll()
			.antMatchers("/slider/**").permitAll()
			.antMatchers("/**").permitAll()
			//.antMatchers("/api/test/**").permitAll()
			.anyRequest().authenticated();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}




/*
 * 
 * public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer  {
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception
	    {
		 http.csrf().disable().authorizeRequests().anyRequest().permitAll(); 

	    }
	
	  @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins(
	                        "http://localhost:4200"
	                )
	                .allowedMethods(
	                        "GET",
	                        "PUT",
	                        "POST",
	                        "DELETE",
	                        "PATCH",
	                        "OPTIONS"
	                );
	    }

	  
	
	
	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/home").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/home")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}*/
	

//}
 










