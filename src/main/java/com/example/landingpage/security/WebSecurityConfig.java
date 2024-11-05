package com.example.landingpage.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private UserDetailsService userDetailsService;
	
	public void SecurityConfig(UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
	  @Bean
	    public AuthenticationManager authenticationManager(
	                                 AuthenticationConfiguration configuration) throws Exception {
	        return configuration.getAuthenticationManager();
	    }
	
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//login and register ---> dont need any token
	    	//but for others mostly we need token for authorizing the access.
//	    	  http.cors()
//			  .and()
//			  .csrf().disable()
//			  .exceptionHandling().authenticationEntryPoint(authEntryPointJwt)
//			  .and()
//			  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//			  .and()
//			  .authorizeHttpRequests()
//			  	.antMatchers("/api/**").permitAll()
////			  	.antMatchers("/api/customer/authenticate").permitAll()
////			  	.antMatchers("/api/staff/authenticate").permitAll()
////			  	.antMatchers("/api/admin/authenticate").permitAll()
//			  	.anyRequest().authenticated();
	    	  
	    	  http.csrf().disable()
              .authorizeHttpRequests((authorize) ->
                      //authorize.anyRequest().authenticated()
                      authorize.requestMatchers(HttpMethod.GET, "/api/v1/**").permitAll()
                              .requestMatchers("/api/v1/**").permitAll()
                              .anyRequest().authenticated()

              );

      return http.build();
	    }

	    
	
}
