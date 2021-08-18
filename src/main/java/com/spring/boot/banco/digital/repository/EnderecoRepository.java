/**
 * 
 */
package com.spring.boot.banco.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.banco.digital.model.Endereco;

/**
 * @author uerviton
 *
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	//CLIAR METODO PERSONALISADO DE BUSCA COM JPQL
	
	
}

