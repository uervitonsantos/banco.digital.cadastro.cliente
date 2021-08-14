/**
 * 
 */
package com.spring.boot.banco.digital.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @author uerviton
 *
 */

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TELEFONE")
public class Telefone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TELEFONE", updatable = false, nullable = false)
	private Long idTelefone;

	@Column(name = "CELULAR_TELEFONE", nullable = false, length = 13)
	private String celularTelefone;

	@Column(name = "RESIDENCIAL_TELEFONE", nullable = true, length = 12)
	private String residencialTelefone;

	@Column(name = "COMERCIAL_TELEFONE", nullable = true, length = 12)
	private String comercialTelefone;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente clienteTelefone;

}
