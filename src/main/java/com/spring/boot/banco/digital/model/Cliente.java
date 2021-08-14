/**
 * 
 */
package com.spring.boot.banco.digital.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.boot.banco.digital.enums.SexoCliente;

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
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLIENTE", updatable = false, nullable = false)
	private Long idCliente;

	@NotBlank(message = "Nome não foi informado")
	@Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula")
	@Column(name = "NOME_CLIENTE", nullable = false, length = 50)
	private String nomeCliente;

	@NotBlank(message = "Sobrenome não foi informado")
	@Column(name = "SOBRENOME_CLIENTE", nullable = false, length = 50)
	private String sobrenomeCliente;

	@NotNull(message = "Sexo do cliente é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name = "SEXO_CLIENTE", nullable = false, length = 9)
	private SexoCliente sexoCliente;

	@NotBlank(message = "Email não foi informado")
	@Email(message = "Campo inválido")
	@Column(name = "EMAIL_CLIENTE", unique = true, nullable = false, length = 50)
	private String emailCliente;

	@NotNull(message = "Status do cliente é obrigatório")
	@BooleanFlag
	@Column(name = "ATIVO_CLIENTE", nullable = false, length = 5)
	private boolean ativoCliente;

	@Column(name = "DATA_CADASTRO_CLIENTE", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataCadastroCliente = new java.util.Date();

	@Column(name = "DATA_ALTERACAO_CLIENTE", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataAlteracaoCliente = new java.util.Date(System.currentTimeMillis());

	@OneToOne(mappedBy = "clienteLogin")
	private Login login;

	@OneToOne(mappedBy = "clienteDocumento")
	private DocumentoCliente documentoCliente;

	@OneToOne(mappedBy = "clienteEnderecos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Endereco listClienteEndereco;

	@OneToOne(mappedBy = "clienteTelefone" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Telefone listClienteTelefone;

}
