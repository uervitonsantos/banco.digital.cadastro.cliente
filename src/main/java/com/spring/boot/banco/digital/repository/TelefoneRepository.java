/**
 * 
 */
package com.spring.boot.banco.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.banco.digital.model.Telefone;

/**
 * @author uerviton
 *
 */

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long>{

	//CLIAR METODO PERSONALISADO DE BUSCA COM JPQL
	
	
}

