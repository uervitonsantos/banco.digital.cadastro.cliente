/**
 * 
 */
package com.spring.boot.banco.digital.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author uerviton-santos
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PESSOA_JURIDICA")
public class PessoaJuridica extends Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@NotBlank(message = "Nome comercial não foi informado")
	@Column(name = "NOME_COMERCIAL", nullable = false, length = 50)
	private String nomeComercial;
	
	@NotBlank(message = "Estatuto social não foi informado")
	@Column(name = "ESTATUTO_SOCIAL", nullable = false, length = 50)
	private String estatutoSocial;
	
	@NotBlank(message = "Ata fundação não foi informado")
	@Column(name = "ATA_FUNDACAO", nullable = false, length = 50)
	private String ataFundacao;
	
	@NotBlank(message = "Ata de diretoria não foi informado")
	@Column(name = "ATA_DIRETORIA", nullable = true, length = 50)
	private String ataAtualDiretoria;
	
	@NotBlank(message = "Seguimento comercial não foi informado")
	@Column(name = "SEGUIMENTO_COMERCIAL", nullable = false, length = 50)
	private String seguimentoComercial;
	
	@NotBlank(message = "Dscrição não foi informado")
	@Column(name = "DESCRICAO", nullable = true, length = 160)
	private String descricao;

}

























