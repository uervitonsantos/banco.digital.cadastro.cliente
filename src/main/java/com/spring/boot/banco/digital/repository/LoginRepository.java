/**
 * 
 */
package com.spring.boot.banco.digital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.banco.digital.model.Login;

/**
 * @author uerviton
 *
 */
@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

	// CLIAR METODO PERSONALISADO DE BUSCA COM JPQL ETC..

	public List<Login> findByLoginCliente(String loginCliente);
}
