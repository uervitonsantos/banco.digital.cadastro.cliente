/**
 * CLASSE DESENVOLVIDA PARA VALIDAR O TIPO DE CLIENTE DO BANCO, (PESSOA FISICA/JURIDICA)
 */
package com.spring.boot.banco.digital.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import com.spring.boot.banco.digital.model.DocumentoCliente;

/**
 * @author uerviton-santos
 *
 */
public class ClienteGroupSequenceProvider implements DefaultGroupSequenceProvider<DocumentoCliente>{

	@Override
	public List<Class<?>> getValidationGroups(DocumentoCliente documentoCliente) {

		List<Class<?>> groups = new ArrayList<>();
		groups.add(DocumentoCliente.class);
		
		if (isPessoaSelecionada(documentoCliente)) {
			groups.add(documentoCliente.getTipoCliente().getGroup());
		}
		return groups;
	}

	private boolean isPessoaSelecionada(DocumentoCliente documentoCliente) {
		return documentoCliente != null && documentoCliente.getTipoCliente() != null;
	}

}
