package gov.tn.defense.security;

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
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import gov.tn.defense.repositories.AppUserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authconfig) throws Exception
	{
		return authconfig.getAuthenticationManager();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService(appUserRepository));
		provider.setPasswordEncoder(passworEncoder());
		provider.setAuthoritiesMapper(new SimpleAuthorityMapper());
		
		return provider;
	}
	
	@Bean
	public PasswordEncoder passworEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService(AppUserRepository appUserRepository)
	{
		return appUserRepository::findByUsername;
	}	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(
					authorize-> {
						try {
							authorize
								.requestMatchers("/category/list").anonymous()
								.requestMatchers("/category/**").authenticated()
								.requestMatchers("/category/add").hasAnyRole("ADMIN", "MEMBER")					
								.anyRequest().permitAll()
							.and()
							.sessionManagement(session-> 
								session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
							
							http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					);
		
		return null;
	}
	
	
	
	
	

}
