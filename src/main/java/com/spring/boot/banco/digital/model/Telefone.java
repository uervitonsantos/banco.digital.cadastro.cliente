/**
 * 
 */
package com.spring.boot.banco.digital.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENTE_ID")
	@JsonBackReference
	private Cliente clienteTelefone;

}
