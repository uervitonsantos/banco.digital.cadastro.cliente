/**
 * 
 */
package com.spring.boot.banco.digital.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.boot.banco.digital.enums.SexoCliente;
import com.spring.boot.banco.digital.enums.UnidadeFederacao;
import com.spring.boot.banco.digital.model.Cliente;
import com.spring.boot.banco.digital.model.DocumentoCliente;
import com.spring.boot.banco.digital.repository.ClienteRepository;
import com.spring.boot.banco.digital.repository.DocumentoRepository;

/**
 * @author uerviton
 *
 */
@Component
public class DummyData {

	@Autowired
	ClienteRepository bancoRepository;

	@Autowired
	DocumentoRepository documentoRepository;

	//@PostConstruct
	public void savePosts() {

		List<Cliente> clienteList = new ArrayList<>();

		Cliente cliente1 = new Cliente();
		cliente1.setNomeCliente("Pedro");
		cliente1.setSobrenomeCliente("de Castro");
		cliente1.setSexoCliente(SexoCliente.MASCULINO);
		cliente1.setEmailCliente("pedro.castro@gmail.com");
		cliente1.setAtivoCliente(true);

		Cliente cliente2 = new Cliente();
		cliente2.setNomeCliente("Lucas");
		cliente2.setSobrenomeCliente("Vieira");
		cliente2.setSexoCliente(SexoCliente.MASCULINO);
		cliente2.setEmailCliente("lucas.vieira@gmail.com");
		cliente2.setAtivoCliente(true);

		Cliente cliente3 = new Cliente();
		cliente3.setNomeCliente("Angela");
		cliente3.setSobrenomeCliente("de Andrade");
		cliente3.setSexoCliente(SexoCliente.FEMININO);
		cliente3.setEmailCliente("angela.andrade@gmail.com");
		cliente3.setAtivoCliente(true);

		Cliente cliente4 = new Cliente();
		cliente4.setNomeCliente("Matheus");
		cliente4.setSobrenomeCliente("Henrique");
		cliente4.setSexoCliente(SexoCliente.MASCULINO);
		cliente4.setEmailCliente("matheus.henrique@gmail.com");
		cliente4.setAtivoCliente(true);

		Cliente cliente5 = new Cliente();
		cliente5.setNomeCliente("Andre");
		cliente5.setSobrenomeCliente("Luiz");
		cliente5.setSexoCliente(SexoCliente.MASCULINO);
		cliente5.setEmailCliente("andre.luiz@gmail.com");
		cliente5.setAtivoCliente(true);

		Cliente cliente6 = new Cliente();
		cliente6.setNomeCliente("José");
		cliente6.setSobrenomeCliente("Renato");
		cliente6.setSexoCliente(SexoCliente.MASCULINO);
		cliente6.setEmailCliente("jose.renato@gmail.com");
		cliente6.setAtivoCliente(true);

		Cliente cliente7 = new Cliente();
		cliente7.setNomeCliente("Carlos");
		cliente7.setSobrenomeCliente("Machado");
		cliente7.setSexoCliente(SexoCliente.MASCULINO);
		cliente7.setEmailCliente("carlos.machado@gmail.com");
		cliente7.setAtivoCliente(true);

		clienteList.add(cliente1);
		clienteList.add(cliente2);
		clienteList.add(cliente3);
		clienteList.add(cliente4);
		clienteList.add(cliente5);
		clienteList.add(cliente6);
		clienteList.add(cliente7);

		for (Cliente cliente : clienteList) {
			Cliente clienteSaved = bancoRepository.save(cliente);
			System.out.println();
			System.out.println(clienteSaved.getIdCliente());
			System.out.println(clienteSaved.getNomeCliente());
			System.out.println(clienteSaved.getSobrenomeCliente());
			System.out.println(clienteSaved.getEmailCliente());
			System.out.println(clienteSaved.getDataCadastroCliente());
			System.out.println(clienteSaved.getDataAlteracaoCliente());
			System.out.println(clienteSaved.isAtivoCliente());
			System.out.println();

		}

	}

	//@PostConstruct
	public void saveDocs() {

		List<DocumentoCliente> documentoClienteList = new ArrayList<>();

		DocumentoCliente documentoCliente1 = new DocumentoCliente();
		documentoCliente1.setCpfCnpjCliente("28621983079");
		documentoCliente1.setNaturalidadeRgCliente("Bahia");
		documentoCliente1.setNomeMaeRgCliente("Maria Claudia Castro");
		documentoCliente1.setNomePaiRgCliente("Jose Carlos Castro");
		documentoCliente1.setNumeroRgCliente("160151065");
		documentoCliente1.setOrgaoEmissorRgCliente("ssp");
		documentoCliente1.setUfRgCliente(UnidadeFederacao.SAO_PAULO);

		documentoClienteList.add(documentoCliente1);

		for (DocumentoCliente documentoCliente : documentoClienteList) {
			DocumentoCliente documentoClienteSaved = documentoRepository.save(documentoCliente);
			System.out.println();
			System.out.println("DOCUMENTO SALVO!" + documentoClienteSaved.getIdDocumentoCliente());
		}

	}

}
