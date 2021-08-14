/**
 * 
 */
package com.spring.boot.banco.digital.enums;

import com.spring.boot.banco.digital.interfaces.CnpjGroup;
import com.spring.boot.banco.digital.interfaces.CpfGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author uerviton-santos
 *
 */
@Getter 
@AllArgsConstructor
public enum TipoCliente {

	FISICA("Física", "CPF", "000.000.000-00", CpfGroup.class),
	JURIDICA("Juŕidica", "CNPJ", "00.000.000/0000-00", CnpjGroup.class);
	
	private final String descricao;
	private final String documento;
	private final String mascara;
	private final Class<?> group;
}
