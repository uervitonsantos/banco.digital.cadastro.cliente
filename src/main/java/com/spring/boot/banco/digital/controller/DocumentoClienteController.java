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

import com.spring.boot.banco.digital.model.DocumentoCliente;
import com.spring.boot.banco.digital.service.DocumentoService;

/**
 * @author uerviton-santos
 *
 */

@RestController
@RequestMapping("/api")
public class DocumentoClienteController {

	@Autowired
	private DocumentoService documentoService;

	// METODO QUE LISTA TODOS OS CLIENTES. TESTE NO POSTMAN
	@GetMapping(value = "/documento/list")
	@ResponseStatus(HttpStatus.OK)
	public List<DocumentoCliente> lista() {
		return documentoService.buscaTodosDocumento();
	}

	// METODO QUE LISTA OS CLIENTES POR Id. TESTE NO POSTMAN
	@GetMapping(value = "/documento/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<DocumentoCliente> buscarPorId(@PathVariable Long id) {
		DocumentoCliente documento = documentoService.buscaDocumentoId(id);
		return ResponseEntity.ok().body(documento);
	}

	// METODO QUE SALVA OS DADOS DOS CLIENTES. TESTE NO POSTMAN
	@PostMapping("/documento")
	@ResponseStatus(HttpStatus.CREATED)
	public DocumentoCliente salva(@RequestBody DocumentoCliente documentoCliente) {
		return documentoService.salvaDocumentoCliente(documentoCliente);

	}

	// METODO QUE ATUALIZA OS DADOS DOS CLIENTES POR ID. TESTE NO POSTMAN
	@PutMapping("/documento/{id}")
	@ResponseStatus(HttpStatus.OK)
	public DocumentoCliente atualiza(@RequestBody DocumentoCliente newDocumentoCliente, @PathVariable Long id) {
		return documentoService.atualizarDocumentoCliente(newDocumentoCliente, id);

	}

	// METODO QUE EXCLUI DOS DADOS DO CLIENTE. BUSCA REALIZADA POR Id. TESTE NO POSTMAN
	@DeleteMapping("/documento/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteDocumento(@PathVariable Long id) {
		documentoService.excluiDocumento(id);

	}

}
