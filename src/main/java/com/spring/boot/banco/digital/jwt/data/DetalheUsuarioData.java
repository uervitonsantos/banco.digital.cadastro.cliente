/**
 * 
 */
package com.spring.boot.banco.digital.jwt.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.boot.banco.digital.model.Login;

/**
 * @author uerviton-santos
 *
 */
public class DetalheUsuarioData implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Optional<Login> login;

	public DetalheUsuarioData(Optional<Login> login) {
		this.login = login;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		return login.orElse(new Login()).getSenhaCliente();
	}

	@Override
	public String getUsername() {
		return login.orElse(new Login()).getLoginCliente();

	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
