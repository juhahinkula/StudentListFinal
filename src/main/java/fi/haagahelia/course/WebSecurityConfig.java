package fi.haagahelia.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import fi.haagahelia.course.service.UserDetailServiceImpl;

@Configuration
@ComponentScan("fi.haagahelia.course")
public class WebSecurityConfig {
	@Autowired
	private UserDetailServiceImpl userDetailsService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
			.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
				.requestMatchers("/css/**", "/signup", "/saveuser").permitAll()
				.anyRequest().authenticated())
			.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/students", true).permitAll())
			.logout(logout -> logout.permitAll()).build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}