/**
 * CLASSE QUE AUXILI NA CLIAÇÃO DE RELATÓRIOS PERSONALIZADOS COM DADOS DOS CLIENTES
 */
package com.spring.boot.banco.digital.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author uerviton-santos
 *
 */

@Getter 
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ClientesByAgenciaDTO {
	
	private Double totalCliente;
	private String codigoAgencia;

}
