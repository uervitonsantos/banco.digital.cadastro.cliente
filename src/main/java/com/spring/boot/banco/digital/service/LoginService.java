/**
 * 
 */
package com.spring.boot.banco.digital.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

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

	public Login atualizarLogin(@RequestBody Login newLogin, @PathVariable Long id) {

		return loginRepository.findById(id).map(login -> {
			login.setIdLoginCliente(newLogin.getIdLoginCliente());
			login.setLoginCliente(newLogin.getLoginCliente());
			login.setSenhaCliente(newLogin.getSenhaCliente());
			login.setDataAlteracaoSenhaCliente(newLogin.getDataAlteracaoSenhaCliente());

			login.setSenhaCliente(encoder.encode(newLogin.getSenhaCliente()));
			return loginRepository.save(login);
		}).orElseGet(() -> {
			newLogin.setIdLoginCliente(id);
			newLogin.setSenhaCliente(encoder.encode(newLogin.getSenhaCliente()));
			return loginRepository.save(newLogin);
		});
	}

	public void excluiLogin(@PathVariable Long id) {
		loginRepository.deleteById(id);

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

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return errors;

	}

}
