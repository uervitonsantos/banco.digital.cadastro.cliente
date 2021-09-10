/**
 * 
 */
package com.spring.boot.banco.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.banco.digital.model.Cliente;

/**
 * @author uerviton
 *
 */

@Repository
public interface PessoaFisicaRepository extends JpaRepository<Cliente, Long>{

	//CLIAR METODO PERSONALISADO DE BUSCA COM JPQL
	
	
}

