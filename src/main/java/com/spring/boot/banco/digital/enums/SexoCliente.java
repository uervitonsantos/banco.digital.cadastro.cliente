/**
 * 
 */
package com.spring.boot.banco.digital.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author uerviton
 *
 */

@Getter 
@NoArgsConstructor
@AllArgsConstructor
public enum SexoCliente {

	MASCULINO("enum.sexo.masculino", "M"), 
	FEMININO("enum.sexo.feminino", "F"),
	OUTROS("enum.sexo.outros", "O");

	private String descripcion;
	private String valor;


}
