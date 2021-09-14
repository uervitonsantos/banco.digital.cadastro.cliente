/**
 * 
 */
package com.spring.boot.banco.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	/*
	 * // METODO QUE LISTA TODOS OS CLIENTES. TESTE NO POSTMAN
	 * 
	 * @GetMapping(value = "/login/list")
	 * 
	 * @ResponseStatus(HttpStatus.OK) public List<Login> listar() { return
	 * loginService.findAllByLogin(); }
	 */

	// METODO QUE SALVA O LOGIM DOS CLIENTES. TESTE NO POSTMAN
	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Login> salvar(@RequestBody Login login) {
		return loginService.savedByLogin(login);
	}

	// METODO QUE ATUALIZA A SENHA DO CLIENTE. TESTE NO POSTMAN
	@PutMapping("/login/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Login atualiza(@RequestBody Login newlogin, @PathVariable Long id) {
		return loginService.atualizarLogin(newlogin, id);

	}

	/*
	 * // METODO QUE EXCLUI A SENHA DO CLIENTE. BUSCA REALIZADA POR Id. TESTE NO //
	 * POSTMAN
	 * 
	 * @DeleteMapping("/login/{id}")
	 * 
	 * @ResponseStatus(HttpStatus.OK) public void deleteLogin(@PathVariable Long id)
	 * { loginService.excluiLogin(id);
	 * 
	 * }
	 */
	
	// METODO QUE VALIDA O LOGIM DOS CLIENTES NO BANCO. TESTE NO POSTMAN
	@GetMapping(value = "/validar")
	public ResponseEntity<Boolean> validar(@RequestParam String loginCliente, @RequestParam String senhaCliente) {
		return loginService.validarSenha(loginCliente, senhaCliente);

	}

}
