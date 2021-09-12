/**
 * 
 */
package com.spring.boot.banco.digital.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.boot.banco.digital.enums.SexoCliente;
import com.spring.boot.banco.digital.enums.UnidadeFederacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author uerviton.santos
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pessoa_fisica")
public class PessoaFisica extends Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Sobrenome não foi informado")
	@Column(name = "SOBRENOME_CLIENTE", nullable = false, length = 50)
	private String sobrenomeCliente;

	@NotNull(message = "Sexo do cliente é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name = "SEXO_CLIENTE", nullable = false, length = 9)
	private SexoCliente sexoCliente;

	@NotBlank
	@Column(name = "NUMERO_RG_CLIENTE", unique = true, nullable = false, length = 11)
	private String numeroRgCliente;

	@NotBlank
	@Column(name = "ORGAO_EMISSOR_RG_CLIENTE", nullable = false, length = 10)
	private String orgaoEmissorRgCliente;

	@NotNull
	@Column(name = "UF_RG_CLIENTE", nullable = false, length = 50)
	@Enumerated(EnumType.STRING)
	private UnidadeFederacao ufRgCliente;

	@NotBlank
	@Column(name = "NATURALIDADE_RG_CLIENTE", nullable = false, length = 13)
	private String naturalidadeRgCliente;

	@Column(name = "DATA_NASCIMENTO_RG_CLIENTE", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Date dataNascimentoRgCliente;

	@NotBlank
	@Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula")
	@Column(name = "NOME_MAE_RG_CLIENTE", nullable = false, length = 50)
	private String nomeMaeRgCliente;

	@NotBlank
	@Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula")
	@Column(name = "NOME_PAI_RG_CLIENTE", nullable = false, length = 50)
	private String nomePaiRgCliente;

	@Column(name = "DATA_EXPEDICAO_RG_CLIENTE", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Date dataExpedicaoRgCliente;

	
}
