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
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.boot.banco.digital.model.Endereco;
import com.spring.boot.banco.digital.repository.EnderecoRepository;

/**
 * @author uerviton-santos
 *
 */

@Service
public class EnderecoService {

	// CLASE QUE TEM COMO RESPONSABILIDADE GERENCIA AS REGRAS DE NEGOCIOS

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco salvaEndereco(@RequestBody @Valid Endereco endereco) {
		return enderecoRepository.save(endereco);

	}

	public Endereco buscaEnderecoId(Long id) {
		return enderecoRepository.findById(id).get();

	}

	public List<Endereco> buscaTodosEnderecos() {
		return enderecoRepository.findAll();

	}

	public Endereco atualizarEnderco(@RequestBody Endereco newEndereco, @PathVariable Long id) {

		return enderecoRepository.findById(id).map(endereco -> {
			endereco.setIdEndereco(newEndereco.getIdEndereco());
			endereco.setBairroEndereco(newEndereco.getBairroEndereco());
			endereco.setCepEndereco(newEndereco.getCepEndereco());
			endereco.setCidadeEndereco(newEndereco.getCidadeEndereco());
			endereco.setEstadoEndereco(newEndereco.getEstadoEndereco());
			endereco.setMunicipioEndereco(newEndereco.getMunicipioEndereco());
			endereco.setNumeroEndereco(newEndereco.getNumeroEndereco());
			endereco.setRuaEndereco(newEndereco.getRuaEndereco());
			endereco.setUfEndereco(newEndereco.getUfEndereco());
			
			return enderecoRepository.save(endereco);
		}).orElseGet(() -> {
			newEndereco.setIdEndereco(id);
			return enderecoRepository.save(newEndereco);
		});
	}

	public void excluiEndereco(@PathVariable Long id) {
		enderecoRepository.deleteById(id);

	}

	// METODO PARA CAPTURAR AS MENSAGENS DE EXCEPTION

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
