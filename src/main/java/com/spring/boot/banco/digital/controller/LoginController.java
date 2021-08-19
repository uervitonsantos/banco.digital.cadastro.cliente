/**
 * 
 */
package com.spring.boot.banco.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.banco.digital.model.Login;
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

	// METODO QUE SALVA O LOGIM DOS CLIENTES. TESTE NO POSTMAN
	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Login> salvar(@RequestBody Login login) {
		return loginService.savedByLogin(login);
	}

	// METODO QUE VALIDA O LOGIM DOS CLIENTES NO BANCO. TESTE NO POSTMAN
	@GetMapping(value = "/validar")
	public ResponseEntity<Boolean> validar(@RequestParam String loginCliente, @RequestParam String senhaCliente) {
		return loginService.validarSenha(loginCliente, senhaCliente);

	}

}
