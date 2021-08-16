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
import com.spring.boot.banco.digital.model.Endereco;
import com.spring.boot.banco.digital.service.ClienteService;
import com.spring.boot.banco.digital.service.EnderecoService;

/**
 * @author uerviton-santos
 *
 */
@RestController
@RequestMapping("/api")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;

	
	// METODO QUE LISTA TODOS OS ENDERECOS. TESTE NO POSTMAN
	@GetMapping(value = "/endereco/list")
	@ResponseStatus(HttpStatus.OK)
	public List<Endereco> lista() {
		return enderecoService.buscaTodosEnderecos();
	}

	// METODO QUE LISTA OS ENDEREÇOS POR Id. TESTE NO POSTMAN
	@GetMapping(value = "/endereco/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Endereco> buscarPorId(@PathVariable Long id) {
		Endereco endereco = enderecoService.buscaEnderecoId(id);
		return ResponseEntity.ok().body(endereco);
	}

	// METODO QUE SALVA OS DADOS DOS ENDEREÇOS. TESTE NO POSTMAN
	@PostMapping("/endereco")
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco salva(@RequestBody Endereco endereco) {
		return enderecoService.salvaEndereco(endereco);

	}

	// METODO QUE ATUALIZA OS DADOS DOS ENDEREÇOS POR ID. TESTE NO POSTMAN
	@PutMapping("/endereco/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Endereco atualiza(@RequestBody Endereco newEndereco, @PathVariable Long id) {
		return enderecoService.atualizarEnderco(newEndereco, id);

	}

	// METODO QUE EXCLUI DOS DADOS DO CLIENTE. BUSCA REALIZADA POR Id. TESTE NO POSTMAN
	@DeleteMapping("/endereco/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable Long id) {
		enderecoService.excluiEndereco(id);

	}

}
