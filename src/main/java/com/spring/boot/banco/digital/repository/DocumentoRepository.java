/**
 * 
 */
package com.spring.boot.banco.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.banco.digital.model.DocumentoCliente;

/**
 * @author uerviton
 *
 */
@Repository
public interface DocumentoRepository extends JpaRepository<DocumentoCliente, Long>{

	//CLIAR METODO PERSONALISADO DE BUSCA COM JPQL
	
	
}

