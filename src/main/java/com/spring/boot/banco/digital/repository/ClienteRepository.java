/**
 * 
 */
package com.spring.boot.banco.digital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.boot.banco.digital.dto.ClientesByAgenciaDTO;
import com.spring.boot.banco.digital.model.Cliente;

/**
 * @author uerviton
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	//CLIAR METODO PERSONALISADO DE BUSCA COM JPQL
	
	@Query("SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
	List<ClientesByAgenciaDTO> clientesByAgenciaDTOs();
}

