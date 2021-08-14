/**
 * 
 */
package com.spring.boot.banco.digital.config;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author uerviton-santos
 *
 */

/*
 * @EnableAuthorizationServer
 * 
 * @EnableWebSecurity
 * 
 * @EnableResourceServer
 */
public class SegurancaConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Bean
	 * 
	 * @Override protected AuthenticationManager authenticationManager() throws
	 * Exception { return super.authenticationManager(); }
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * PasswordEncoder encoder =
	 * PasswordEncoderFactories.createDelegatingPasswordEncoder();
	 * auth.inMemoryAuthentication().withUser("bancodigital").password(encoder.
	 * encode("qw35erty#uio78p")) .roles("ADMIN");
	 * 
	 * super.configure(auth); }
	 * 
	 * 
	 * @Bean public PasswordEncoder getPasswordEncoder() { BCryptPasswordEncoder
	 * encoder = new BCryptPasswordEncoder(); return encoder;
	 * 
	 * }
	 */
}
