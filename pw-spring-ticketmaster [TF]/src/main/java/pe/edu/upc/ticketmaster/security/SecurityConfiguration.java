package pe.edu.upc.ticketmaster.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;





@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	//Instanciar la clase
	@Autowired
	private LoggingAccessDeniedHandler loggingAccessDeniedHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
			.authorizeRequests()
				.antMatchers("/").permitAll()
				
				
				.antMatchers("/customers").hasRole("ADMIN")
				.antMatchers("/customers/**").hasRole("ADMIN")
				.antMatchers("/organisers").hasRole("ADMIN")
				.antMatchers("/organisers/**").hasRole("ADMIN")
				.antMatchers("/shows").hasRole("ADMIN")
				.antMatchers("/shows/**").hasRole("ADMIN")
				.antMatchers("/tickets").hasRole("ADMIN")
				.antMatchers("/tickets/**").hasRole("ADMIN")
				.antMatchers("/genders").hasRole("ADMIN")
				.antMatchers("/genders/**").hasRole("ADMIN")
				.antMatchers("/feedbacks").hasRole("ADMIN")
				.antMatchers("/feedbacks/**").hasRole("ADMIN")
				.antMatchers("/countries").hasRole("ADMIN")
				.antMatchers("/countries/**").hasRole("ADMIN")
				.antMatchers("/paymentOptions").hasRole("ADMIN")
				.antMatchers("/paymentOptions/**").hasRole("ADMIN")
				.antMatchers("/eventTypes").hasRole("ADMIN")
				.antMatchers("/eventTypes/**").hasRole("ADMIN")
				.antMatchers("/search/admin/**").hasRole("ADMIN")
				
				
				.antMatchers("/listAllTicketsCustomer/**").hasAnyRole("CUSTOMER")
				.antMatchers("/listAllFeedbackCustomer").hasRole("CUSTOMER")
				.antMatchers("/listAllOrganiserCustomer").hasAnyRole("CUSTOMER","ADMIN")
				.antMatchers("/buys/**").hasRole("CUSTOMER")
				.antMatchers("/listAllShowCustomer/**").hasRole("CUSTOMER")
				.antMatchers("/listAllShowCustomerByEventType/**").hasRole("CUSTOMER")
				.antMatchers("/listAllShowCustomerByOrganiser/**").hasRole("CUSTOMER")
				.antMatchers("/search/customer/**").hasAnyRole("ADMIN","CUSTOMER")
				
				
				.antMatchers("/listAllFeedbackOrganiser").hasRole("ORGANISER")
				.antMatchers("/listAllTicketsOrganiser").hasRole("ORGANISER")
				.antMatchers("/showsOrganiserController/**").hasRole("ORGANISER")
				.antMatchers("/search/organiser/**").hasRole("ORGANISER")
				
						
			.and()
			.formLogin()
			.loginProcessingUrl("/signin")
			.loginPage("/login").permitAll()
			.usernameParameter("username")
			.passwordParameter("password")
		 	.and()
		 	.logout()
		 		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/")
			.and()
			.exceptionHandling()
			.accessDeniedHandler(loggingAccessDeniedHandler);
		
			;
			//Registrar el acces Denied
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// Aqui se crea el vinculo entre el Spring security y el PasswordEncoder y UserDetailsService
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.myUserDetailsService);
		return daoAuthenticationProvider;
	}
}
