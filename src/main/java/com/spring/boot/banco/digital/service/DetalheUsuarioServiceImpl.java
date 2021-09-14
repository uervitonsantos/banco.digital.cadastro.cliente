/**
 * 
 */
package com.spring.boot.banco.digital.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.spring.boot.banco.digital.jwt.data.DetalheUsuarioData;
import com.spring.boot.banco.digital.model.Login;
import com.spring.boot.banco.digital.repository.LoginRepository;

/**
 * @author uerviton-santos
 *
 */
@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {

	private final LoginRepository repository;

	public DetalheUsuarioServiceImpl(LoginRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Login> usuario = repository.findByLoginCliente(username);
		if (usuario.isEmpty()) {
			throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
		}

		return new DetalheUsuarioData(usuario);
	}

}
