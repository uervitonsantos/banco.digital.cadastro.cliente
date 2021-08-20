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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.banco.digital.model.Cliente;
import com.spring.boot.banco.digital.service.ClienteService;

/**
 * @author uerviton
 *
 */

@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	// METODO QUE LISTA TODOS OS CLIENTES. TESTE NO POSTMAN
	@GetMapping(value = "/cliente/list")
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> lista() {
		return clienteService.buscaTodosClientes();
	}

	// METODO QUE LISTA OS CLIENTES POR Id. TESTE NO POSTMAN
	@GetMapping(value = "/cliente/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
		Cliente cliente = clienteService.buscaClienteId(id);
		return ResponseEntity.ok().body(cliente);
	}

	// METODO QUE SALVA OS DADOS DOS CLIENTES. TESTE NO POSTMAN
	@PostMapping("/cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salva(@RequestBody Cliente cliente) {
		return clienteService.salvaCliente(cliente);

	}

	// METODO QUE ATUALIZA OS DADOS DOS CLIENTES POR ID. TESTE NO POSTMAN
	@PutMapping("/cliente/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cliente atualiza(@RequestBody Cliente newCliente, @PathVariable Long id) {
		return clienteService.atualizarCliente(newCliente, id);

	}

	// METODO QUE EXCLUI DOS DADOS DO CLIENTE. BUSCA REALIZADA POR Id. TESTE NO
	// POSTMAN
	@DeleteMapping("/cliente/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable Long id) {
		clienteService.excluiCliente(id);

	}

}
