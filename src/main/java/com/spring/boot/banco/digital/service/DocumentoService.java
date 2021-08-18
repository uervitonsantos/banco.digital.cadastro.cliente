/**
 * 
 */
package com.spring.boot.banco.digital.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.boot.banco.digital.model.DocumentoCliente;
import com.spring.boot.banco.digital.repository.DocumentoRepository;

/**
 * @author uerviton-santos
 *
 */

@Service
public class DocumentoService {

	// CLASE QUE TEM COMO RESPONSABILIDADE GERENCIA AS REGRAS DE NEGOCIOS

	@Autowired
	private DocumentoRepository documentoRepository;

	public DocumentoCliente salvaDocumentoCliente(@RequestBody @Valid DocumentoCliente documentoCliente) {
		return documentoRepository.save(documentoCliente);

	}

	public DocumentoCliente buscaDocumentoId(Long id) {
		return documentoRepository.findById(id).get();

	}

	public List<DocumentoCliente> buscaTodosDocumento() {
		return documentoRepository.findAll();

	}

	public DocumentoCliente atualizarDocumentoCliente(@RequestBody DocumentoCliente newDocumento,
			@PathVariable Long id) {

		return documentoRepository.findById(id).map(documento -> {
			documento.setIdDocumentoCliente(newDocumento.getIdDocumentoCliente());
			documento.setTipoCliente(newDocumento.getTipoCliente());
			documento.setNumeroRgCliente(newDocumento.getNumeroRgCliente());
			documento.setOrgaoEmissorRgCliente(newDocumento.getOrgaoEmissorRgCliente());
			documento.setUfRgCliente(newDocumento.getUfRgCliente());
			documento.setNaturalidadeRgCliente(newDocumento.getNaturalidadeRgCliente());
			documento.setDataNascimentoRgCliente(newDocumento.getDataNascimentoRgCliente());
			documento.setNomeMaeRgCliente(newDocumento.getNomeMaeRgCliente());
			documento.setNomePaiRgCliente(newDocumento.getNumeroRgCliente());
			documento.setDataExpedicaoRgCliente(newDocumento.getDataExpedicaoRgCliente());
			documento.setCpfCnpjCliente(newDocumento.getCpfCnpjCliente());

			return documentoRepository.save(documento);
		}).orElseGet(() -> {
			newDocumento.setIdDocumentoCliente(id);
			return documentoRepository.save(newDocumento);
		});
	}

	public void excluiDocumento(@PathVariable Long id) {
		documentoRepository.deleteById(id);

	}

}
