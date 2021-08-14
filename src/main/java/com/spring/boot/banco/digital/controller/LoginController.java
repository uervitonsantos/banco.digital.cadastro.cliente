/**
 * 
 */
package com.spring.boot.banco.digital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.banco.digital.model.Login;
import com.spring.boot.banco.digital.repository.LoginRepository;
import com.spring.boot.banco.digital.service.LoginService;

/**
 * @author uerviton-santos
 *
 */
@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private PasswordEncoder encoder;

	// METODO QUE LISTA TODOS OS CLIENTES. TESTE NO POSTMAN
	@GetMapping(value = "/login/list")
	@ResponseStatus(HttpStatus.OK)
	public List<Login> listar() {
		return loginService.findAllByLogin();
	}

	/*
	 * // METODO QUE LISTA OS CLIENTES POR Id. TESTE NO POSTMAN
	 * 
	 * @GetMapping(value = "/cliente/{id}")
	 * 
	 * @ResponseStatus(HttpStatus.OK) public ResponseEntity<Cliente>
	 * buscarPorId(@PathVariable Long id) { Cliente cliente =
	 * clienteService.buscaClienteId(id); return ResponseEntity.ok().body(cliente);
	 * }
	 */

	// METODO QUE SALVA OS DADOS DOS CLIENTES. TESTE NO POSTMAN
	@PostMapping("/login")
	 public ResponseEntity<Login> salvar(@RequestBody Login login) {
        login.setSenhaCliente(encoder.encode(login.getSenhaCliente()));
        return ResponseEntity.ok(loginRepository.save(login));
    }

	@GetMapping(value = "/validar")
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
