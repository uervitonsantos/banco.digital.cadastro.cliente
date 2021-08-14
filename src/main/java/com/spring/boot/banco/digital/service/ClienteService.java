/**
 * 
 */
package com.spring.boot.banco.digital.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.boot.banco.digital.dto.ClientesByAgenciaDTO;
import com.spring.boot.banco.digital.model.Cliente;
import com.spring.boot.banco.digital.repository.ClienteRepository;

/**
 * @author uerviton-santos
 *
 */

@Service
public class ClienteService {

	// CLASE QUE TEM COMO RESPONSABILIDADE GERENCIA AS REGRAS DE NEGOCIOS

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvaCliente(@RequestBody @Valid Cliente cliente) {
		return clienteRepository.save(cliente);

	}

	public Cliente buscaClienteId(Long id) {
		return clienteRepository.findById(id).get();

	}

	public List<Cliente> buscaTodosClientes() {
		return clienteRepository.findAll();

	}

	public Cliente atualizarCliente(@RequestBody Cliente newcliente, @PathVariable Long id) {

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
	}

	public void excluiCliente(@PathVariable Long id) {
		clienteRepository.deleteById(id);

	}

	@Transactional(readOnly = true)
	public List<ClientesByAgenciaDTO> clientesByAgenciaDTOs() {
		return clienteRepository.clientesByAgenciaDTOs();
	}

	
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  @ExceptionHandler(MethodArgumentNotValidException.class) public Map<String,
	  String> handleValidationException(MethodArgumentNotValidException ex) {
	  Map<String, String> errors = new HashMap<>();
	  
	  ex.getBindingResult().getAllErrors().forEach((error) -> { String fieldName =
	  ((FieldError) error).getField(); String errorMessage =
	  error.getDefaultMessage(); errors.put(fieldName, errorMessage); });
	  
	  return errors;
	  
	  }
	 
}
