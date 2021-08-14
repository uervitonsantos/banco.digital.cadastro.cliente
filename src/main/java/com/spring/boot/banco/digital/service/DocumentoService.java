/**
 * 
 */
package com.spring.boot.banco.digital.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.boot.banco.digital.model.DocumentoCliente;
import com.spring.boot.banco.digital.repository.DocumentoRepository;

/**
 * @author uerviton-santos
 *
 */

@Service
public class DocumentoService {

	// CLASE QUE TEM COMO RESPONSABILIDADE GERENCIA AS REGRAS DE NEGOCIOS

	@Autowired
	private DocumentoRepository documentoRepository;
	
	
	public DocumentoCliente salvaDocumentoCliente(@RequestBody @Valid DocumentoCliente documentoCliente) {
		return documentoRepository.save(documentoCliente);

	}
	
	public DocumentoCliente buscaDocumentoId(Long id) {
		return documentoRepository.findById(id).get();
		
	}
	
	public List<DocumentoCliente> buscaTodosDocumento() {
		return documentoRepository.findAll();
		
	}
	
	/*public Cliente atualizarCliente(@RequestBody Cliente newcliente, @PathVariable Long id) {

		return clienteRepository.findById(id).map(cliente -> {
			cliente.setIdCliente(newcliente.getIdCliente());
			cliente.setNomeCliente(newcliente.getNomeCliente());
			cliente.setSobrenomeCliente(newcliente.getSobrenomeCliente());
			cliente.setSexoCliente(newcliente.getSexoCliente());
			cliente.setEmailCliente(newcliente.getEmailCliente());
			cliente.setAtivoCliente(newcliente.isAtivoCliente());
			cliente.setDataCadastroCliente(newcliente.getDataCadastroCliente());
			cliente.setDataAlteracaoCliente(newcliente.getDataAlteracaoCliente());

			return clienteRepository.save(cliente);
		}).orElseGet(() -> {
			newcliente.setIdCliente(id);
			return clienteRepository.save(newcliente);
		});
	}*/

	
	public void excluiDocumento(@PathVariable Long id) {
		documentoRepository.deleteById(id);

	}

	
}
