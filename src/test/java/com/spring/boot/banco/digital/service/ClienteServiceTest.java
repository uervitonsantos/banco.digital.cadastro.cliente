/**
 * 
 */
package com.spring.boot.banco.digital.service;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.boot.banco.digital.repository.ClienteRepository;

/**
 * @author uerviton-santos
 *
 */

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {
	
	@Mock
	private ClienteRepository clienteRepository;
		
	@InjectMocks
	private ClienteService clienteService;
	

	/**
	 * Test method for {@link com.spring.boot.banco.digital.service.ClienteService#salvaCliente(com.spring.boot.banco.digital.model.Cliente)}.
	 */
	@Test
	void quandoClienteForInformado_EntaoClienteDeveSerCriado() {
		fail("Not yet implemented");
	}
	
	

	/**
	 * Test method for {@link com.spring.boot.banco.digital.service.ClienteService#buscaClienteId(java.lang.Long)}.
	 */
	@Test
	void testBuscaClienteId() {
		fail("Not yet implemented");
	}

	
	/**
	 * Test method for {@link com.spring.boot.banco.digital.service.ClienteService#buscaTodosClientes()}.
	 */
	@Test
	void testBuscaTodosClientes() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.spring.boot.banco.digital.service.ClienteService#atualizarCliente(com.spring.boot.banco.digital.model.Cliente, java.lang.Long)}.
	 */
	@Test
	void testAtualizarCliente() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.spring.boot.banco.digital.service.ClienteService#excluiCliente(java.lang.Long)}.
	 */
	@Test
	void testExcluiCliente() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.spring.boot.banco.digital.service.ClienteService#clientesByAgenciaDTOs()}.
	 */
	@Test
	void testClientesByAgenciaDTOs() {
		fail("Not yet implemented");
	}

}
