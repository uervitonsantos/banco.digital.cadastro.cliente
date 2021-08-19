/**
 * 
 */
package com.spring.boot.banco.digital.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author uerviton
 *
 */

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LOGIN")
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_LOGIN_CLIENTE", updatable = false, nullable = false)
	private Long idLoginCliente;

	@NotBlank
	@Column(name = "LOGIN_CLIENTE", unique = true, nullable = true, length = 20)
	private String loginCliente;

	@NotBlank
	//@JsonIgnore
	@Column(name = "SENHA_CLIENTE", nullable = true, length = 60)
	private String senhaCliente;

	@Column(name = "DATA_ALTERACAO_SENHA_CLIENTE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dataAlteracaoSenhaCliente = new java.sql.Date(System.currentTimeMillis());

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	@JsonBackReference
	private Cliente clienteLogin;
}
