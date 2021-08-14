/**
 * 
 */
package com.spring.boot.banco.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.banco.digital.model.DocumentoCliente;

/**
 * @author uerviton
 *
 */
public interface TelefoneRepository2 extends JpaRepository<DocumentoCliente, Long>{

	//CLIAR METODO PERSONALISADO DE BUSCA COM JPQL
	
	
}

