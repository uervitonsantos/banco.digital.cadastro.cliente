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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.boot.banco.digital.enums.TipoCliente;
import com.spring.boot.banco.digital.enums.UnidadeFederacao;
import com.spring.boot.banco.digital.interfaces.CnpjGroup;
import com.spring.boot.banco.digital.interfaces.CpfGroup;
import com.spring.boot.banco.digital.service.ClienteGroupSequenceProvider;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author uerviton.santos
 *
 */

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DOCUMENTO_CLIENTE")
@GroupSequenceProvider(ClienteGroupSequenceProvider.class)
public class DocumentoCliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DOCUMENTO_CLIENTE", updatable = false, nullable = false)
	private Long idDocumentoCliente;

	@NotNull
	@Column(name = "TIPO_CLIENTE", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private TipoCliente tipoCliente;

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

	@Column(name = "DATA_NASCIMNTO_RG_CLIENTE", nullable = false)
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

	@CPF(groups = CpfGroup.class)
	@CNPJ(groups = CnpjGroup.class)
	@NotBlank(message = "CPF/CNPJ é obrigatório")
	@Column(name = "CPF_CNPJ_CLIENTE", unique = true, nullable = false, length = 14)
	private String cpfCnpjCliente;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	@JsonBackReference
	private Cliente clienteDocumento;
}
