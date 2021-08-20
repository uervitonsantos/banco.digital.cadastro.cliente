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

import com.spring.boot.banco.digital.model.Telefone;
import com.spring.boot.banco.digital.repository.TelefoneRepository;

/**
 * @author uerviton-santos
 *
 */

@Service
public class TelefoneService {
	
	// CLASE QUE TEM COMO RESPONSABILIDADE GERENCIA AS REGRAS DE NEGOCIOS

		@Autowired
		private TelefoneRepository telefoneRepository;

		public Telefone salvaTelefone(@RequestBody @Valid Telefone telefone) {
			return telefoneRepository.save(telefone);

		}

		public Telefone buscaTelefoneId(Long id) {
			return telefoneRepository.findById(id).get();

		}

		public List<Telefone> buscaTodosTelefone() {
			return telefoneRepository.findAll();

		}

		public Telefone atualizarTelefone(@RequestBody Telefone newTelefone, @PathVariable Long id) {
			return telefoneRepository.findById(id).map(telefone -> {
				telefone.setIdTelefone(newTelefone.getIdTelefone());
				telefone.setCelularTelefone(newTelefone.getCelularTelefone());
				telefone.setResidencialTelefone(newTelefone.getResidencialTelefone());
				telefone.setComercialTelefone(newTelefone.getComercialTelefone());
				return telefoneRepository.save(telefone);
			}).orElseGet(() -> {
				newTelefone.setIdTelefone(id);
				return telefoneRepository.save(newTelefone);
			});
		}

		public void excluiTelefone(@PathVariable Long id) {
			telefoneRepository.deleteById(id);

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
