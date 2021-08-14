/**
 * 
 */
package com.spring.boot.banco.digital.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spring.boot.banco.digital.enums.UnidadeFederacao;

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
@Table(name = "ENDERECO")
public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ENDERECO", updatable = false, nullable = false)
	private Long idEndereco;

	@Column(name = "RUA_ENDERECO", nullable = false, length = 20)
	private String ruaEndereco;

	@Column(name = "NUMERO_ENDERECO", nullable = false, length = 5)
	private String numeroEndereco;

	@Column(name = "BAIRRO_ENDERECO", nullable = false, length = 20)
	private String bairroEndereco;

	@Column(name = "MUNICIPIO_ENDERECO", nullable = false, length = 20)
	private String municipioEndereco;

	@Column(name = "CIDADE_ENDERECO", nullable = false, length = 20)
	private String cidadeEndereco;

	@Column(name = "ESTADO_ENDERECO", nullable = false, length = 20)
	private String estadoEndereco;

	@Column(name = "UF_ENDERECO_CLIENTE", nullable = false, length = 8)
	private UnidadeFederacao ufEndereco;

	@Column(name = "CEP_ENDERECO", nullable = false, length = 8)
	private int cepEndereco;

}