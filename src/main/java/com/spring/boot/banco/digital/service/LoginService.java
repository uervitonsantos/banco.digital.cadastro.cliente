/**
 * 
 */
package com.spring.boot.banco.digital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.banco.digital.model.Login;
import com.spring.boot.banco.digital.repository.LoginRepository;

/**
 * @author uerviton-santos
 *
 */

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private PasswordEncoder encoder;

	public List<Login> findAllByLogin() {
		return loginRepository.findAll();
	}
	
	public ResponseEntity<Login> savedByLogin(@RequestBody Login login) {
        login.setSenhaCliente(encoder.encode(login.getSenhaCliente()));
        return ResponseEntity.ok(loginRepository.save(login));
    }
	
	public ResponseEntity<Boolean> validarSenha(@RequestParam String loginCliente, @RequestParam String senhaCliente) {

		List<Login> optLogin = loginRepository.findByLoginCliente(loginCliente);
		if (optLogin.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
		}
		Login login = optLogin.get(0);
		boolean valid = encoder.matches(senhaCliente, login.getSenhaCliente());

		HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		return ResponseEntity.status(status).body(valid);

	}

}
