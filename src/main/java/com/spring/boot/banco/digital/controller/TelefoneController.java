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

import com.spring.boot.banco.digital.model.Telefone;
import com.spring.boot.banco.digital.service.TelefoneService;

/**
 * @author uerviton-santos
 *
 */

@RestController
@RequestMapping("/api")
public class TelefoneController {

	@Autowired
	private TelefoneService telefoneService;

	// METODO QUE LISTA TODOS OS TELEFONES DOS CLIENTES. TESTE NO POSTMAN
	@GetMapping(value = "/telefone/list")
	@ResponseStatus(HttpStatus.OK)
	public List<Telefone> lista() {
		return telefoneService.buscaTodosTelefone();
	}

	// METODO QUE LISTA OS TELEFONES DOS CLIENTES POR Id. TESTE NO POSTMAN
	@GetMapping(value = "/telefone/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Telefone> buscarPorId(@PathVariable Long id) {
		Telefone telefone = telefoneService.buscaTelefoneId(id);
		return ResponseEntity.ok().body(telefone);
	}

	// METODO QUE SALVA OS TELEONES DOS CLIENTES. TESTE NO POSTMAN
	@PostMapping("/telefone")
	@ResponseStatus(HttpStatus.CREATED)
	public Telefone salva(@RequestBody Telefone telefone) {
		return telefoneService.salvaTelefone(telefone);

	}

	// METODO QUE ATUALIZA OS DADOS DOS CLIENTES POR ID. TESTE NO POSTMAN
	@PutMapping("/telefone/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Telefone atualiza(@RequestBody Telefone newtelefone, @PathVariable Long id) {
		return telefoneService.atualizarTelefone(newtelefone, id);

	}

	// METODO QUE EXCLUI DOS DADOS DO CLIENTE. BUSCA REALIZADA POR Id. TESTE NO
	// POSTMAN
	@DeleteMapping("/telefone/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteTelefone(@PathVariable Long id) {
		telefoneService.excluiTelefone(id);

	}

}
