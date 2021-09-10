/**
 * CLASSE DESENVOLVIDA PARA VALIDAR O TIPO DE CLIENTE DO BANCO, (PESSOA FISICA/JURIDICA)
 */
package com.spring.boot.banco.digital.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import com.spring.boot.banco.digital.model.Cliente;

/**
 * @author uerviton-santos
 *
 */
public class ClienteGroupSequenceProvider implements DefaultGroupSequenceProvider<Cliente>{

	@Override
	public List<Class<?>> getValidationGroups(Cliente cliente) {

		List<Class<?>> groups = new ArrayList<>();
		groups.add(Cliente.class);
		
		if (isPessoaSelecionada(cliente)) {
			groups.add(cliente.getTipoCliente().getGroup());
		}
		return groups;
	}

	private boolean isPessoaSelecionada(Cliente cliente) {
		return cliente != null && cliente.getTipoCliente() != null;
	}

}
