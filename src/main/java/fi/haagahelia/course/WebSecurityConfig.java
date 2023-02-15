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
    	http
    		.authorizeHttpRequests().requestMatchers("/css/**", "/signup", "/saveuser").permitAll() // Enable css when logged out
    			.and()
            .authorizeHttpRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/students", true)
                .permitAll()
            	.and()
            .logout()
            	.permitAll()
            	.and();
    	
    	return http.build();
    }
     
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}