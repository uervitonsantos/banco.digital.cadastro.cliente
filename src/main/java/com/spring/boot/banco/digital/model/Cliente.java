/**
 * 
 */
package com.spring.boot.banco.digital.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.boot.banco.digital.enums.TipoCliente;
import com.spring.boot.banco.digital.interfaces.CnpjGroup;
import com.spring.boot.banco.digital.interfaces.CpfGroup;
import com.spring.boot.banco.digital.service.ClienteGroupSequenceProvider;

import jdk.jfr.BooleanFlag;
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
@Entity
@Table(name = "CLIENTE")
@DiscriminatorColumn(name = "CLIENTE_TIPO")
@Inheritance(strategy = InheritanceType.JOINED)
@GroupSequenceProvider(ClienteGroupSequenceProvider.class)
public abstract class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLIENTE", updatable = false, nullable = false)
	private Long idCliente;
	
	@CPF(groups = CpfGroup.class)
	@CNPJ(groups = CnpjGroup.class)
	@NotBlank(message = "CPF/CNPJ é obrigatório")
	@Column(name = "CPF_CNPJ_CLIENTE", unique = true, nullable = false, length = 14)
	private String cpfCnpjCliente;

	@NotBlank(message = "Nome não foi informado")
	@Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula")
	@Column(name = "NOME_CLIENTE", nullable = false, length = 50)
	private String nomeCliente;

	@NotBlank(message = "Email não foi informado")
	@Email(message = "Campo inválido")
	@Column(name = "EMAIL_CLIENTE", unique = true, nullable = false, length = 50)
	private String emailCliente;
	
	@Column(name = "DATA_CADASTRO_CLIENTE", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataCadastroCliente = new java.util.Date();

	@Column(name = "DATA_ALTERACAO_CLIENTE", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataAlteracaoCliente = new java.util.Date(System.currentTimeMillis());
	
	@NotNull(message = "Status do cliente é obrigatório")
	@BooleanFlag
	@Column(name = "ATIVO_CLIENTE", nullable = false, length = 5)
	private boolean ativoCliente;
	
	@NotNull
	@Column(name = "TIPO_CLIENTE", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private TipoCliente tipoCliente;

	@OneToOne(mappedBy = "clienteLogin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Login loginCliente;
	
	@OneToOne(mappedBy = "clienteEnderecos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Endereco enderecoCliente;

	@OneToOne(mappedBy = "clienteTelefone", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Telefone telefoneCliente;

}
