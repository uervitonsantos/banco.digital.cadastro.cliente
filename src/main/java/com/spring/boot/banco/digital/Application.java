package com.spring.boot.banco.digital;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.boot.banco.digital.enums.SexoCliente;
import com.spring.boot.banco.digital.enums.TipoCliente;
import com.spring.boot.banco.digital.enums.UnidadeFederacao;
import com.spring.boot.banco.digital.model.Cliente;
import com.spring.boot.banco.digital.model.PessoaFisica;
import com.spring.boot.banco.digital.model.Endereco;
import com.spring.boot.banco.digital.model.Login;
import com.spring.boot.banco.digital.model.Telefone;
import com.spring.boot.banco.digital.service.ClienteService;
import com.spring.boot.banco.digital.service.EnderecoService;
import com.spring.boot.banco.digital.service.LoginService;
import com.spring.boot.banco.digital.service.TelefoneService;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class })
public class Application implements CommandLineRunner {

	//@Autowired
	ClienteService clienteService;

	//@Autowired
	//DocumentoService documentoService;

	//@Autowired
	EnderecoService enderecoService;

	//@Autowired
	LoginService loginService;

	//@Autowired
	TelefoneService telefoneService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	@Override
	public void run(String... args) throws Exception {

		
		
		/*
		 * Cliente cliente1 = new Cliente(); cliente1.setNomeCliente("Pedro");
		 * cliente1.setSobrenomeCliente("de Castro");
		 * cliente1.setSexoCliente(SexoCliente.MASCULINO);
		 * cliente1.setEmailCliente("pedro.castro@gmail.com");
		 * cliente1.setAtivoCliente(true);
		 * 
		 * Cliente cliente2 = new Cliente(); cliente2.setNomeCliente("Lucas");
		 * cliente2.setSobrenomeCliente("Vieira");
		 * cliente2.setSexoCliente(SexoCliente.MASCULINO);
		 * cliente2.setEmailCliente("lucas.vieira@gmail.com");
		 * cliente2.setAtivoCliente(true);
		 * 
		 * Cliente cliente3 = new Cliente(); cliente3.setNomeCliente("Angela");
		 * cliente3.setSobrenomeCliente("de Andrade");
		 * cliente3.setSexoCliente(SexoCliente.FEMININO);
		 * cliente3.setEmailCliente("angela.andrade@gmail.com");
		 * cliente3.setAtivoCliente(true);
		 * 
		 * Cliente cliente4 = new Cliente(); cliente4.setNomeCliente("Matheus");
		 * cliente4.setSobrenomeCliente("Henrique");
		 * cliente4.setSexoCliente(SexoCliente.MASCULINO);
		 * cliente4.setEmailCliente("matheus.henrique@gmail.com");
		 * cliente4.setAtivoCliente(true);
		 * 
		 * Cliente cliente5 = new Cliente(); cliente5.setNomeCliente("Andre");
		 * cliente5.setSobrenomeCliente("Luiz");
		 * cliente5.setSexoCliente(SexoCliente.MASCULINO);
		 * cliente5.setEmailCliente("andre.luiz@gmail.com");
		 * cliente5.setAtivoCliente(true);
		 * 
		 * Cliente cliente6 = new Cliente(); cliente6.setNomeCliente("José");
		 * cliente6.setSobrenomeCliente("Renato");
		 * cliente6.setSexoCliente(SexoCliente.MASCULINO);
		 * cliente6.setEmailCliente("jose.renato@gmail.com");
		 * cliente6.setAtivoCliente(true);
		 * 
		 * Cliente cliente7 = new Cliente(); cliente7.setNomeCliente("Carlos");
		 * cliente7.setSobrenomeCliente("Machado");
		 * cliente7.setSexoCliente(SexoCliente.MASCULINO);
		 * cliente7.setEmailCliente("carlos.machado@gmail.com");
		 * cliente7.setAtivoCliente(true);
		 * 
		 * clienteService.salvaCliente(cliente1); clienteService.salvaCliente(cliente2);
		 * clienteService.salvaCliente(cliente3); clienteService.salvaCliente(cliente4);
		 * clienteService.salvaCliente(cliente5); clienteService.salvaCliente(cliente6);
		 * clienteService.salvaCliente(cliente7);
		 * 
		 * Endereco endereco1 = new Endereco();
		 * endereco1.setRuaEndereco("Rua Amazonas"); endereco1.setNumeroEndereco("23");
		 * endereco1.setBairroEndereco("Alvorada");
		 * endereco1.setMunicipioEndereco("Alvorada");
		 * endereco1.setCidadeEndereco("Manaus"); endereco1.setEstadoEndereco("AM");
		 * endereco1.setUfEndereco(UnidadeFederacao.AMAZONAS);
		 * endereco1.setCepEndereco("08566788");
		 * endereco1.setClienteEnderecos(cliente1);
		 * 
		 * Endereco endereco2 = new Endereco();
		 * endereco2.setRuaEndereco("Rua São Paulo"); endereco2.setNumeroEndereco("23");
		 * endereco2.setBairroEndereco("Osasco");
		 * endereco2.setMunicipioEndereco("Centro");
		 * endereco2.setCidadeEndereco("Osasco"); endereco2.setEstadoEndereco("SP");
		 * endereco2.setUfEndereco(UnidadeFederacao.SAO_PAULO);
		 * endereco2.setCepEndereco("08566788");
		 * endereco2.setClienteEnderecos(cliente2);
		 * 
		 * enderecoService.salvaEndereco(endereco1);
		 * enderecoService.salvaEndereco(endereco2);
		 * 
		 * DocumentoCliente documentoCliente1 = new DocumentoCliente();
		 * documentoCliente1.setTipoCliente(TipoCliente.FISICA);
		 * documentoCliente1.setCpfCnpjCliente("28621983079");
		 * documentoCliente1.setNaturalidadeRgCliente("Bahia");
		 * documentoCliente1.setNomeMaeRgCliente("Maria Claudia Castro");
		 * documentoCliente1.setNomePaiRgCliente("Jose Carlos Castro");
		 * documentoCliente1.setNumeroRgCliente("160151065");
		 * documentoCliente1.setDataExpedicaoRgCliente(new Date(2017 - 12 - 25));
		 * documentoCliente1.setDataNascimentoRgCliente(new Date(2017 - 12 - 25));
		 * documentoCliente1.setOrgaoEmissorRgCliente("ssp");
		 * documentoCliente1.setUfRgCliente(UnidadeFederacao.SAO_PAULO);
		 * documentoCliente1.setClienteDocumento(cliente1);
		 * 
		 * DocumentoCliente documentoCliente2 = new DocumentoCliente();
		 * documentoCliente2.setTipoCliente(TipoCliente.JURIDICA);
		 * documentoCliente2.setCpfCnpjCliente("85310624000168");
		 * documentoCliente2.setNaturalidadeRgCliente("São Paulo");
		 * documentoCliente2.setNomeMaeRgCliente("Maria Claudia Castro");
		 * documentoCliente2.setNomePaiRgCliente("Jose Carlos Castro");
		 * documentoCliente2.setNumeroRgCliente("262858368");
		 * documentoCliente2.setDataExpedicaoRgCliente(new Date(13 - 06 - 2012));
		 * documentoCliente2.setDataNascimentoRgCliente(new Date(13 - 06 - 2012));
		 * documentoCliente2.setOrgaoEmissorRgCliente("sba");
		 * documentoCliente2.setUfRgCliente(UnidadeFederacao.DISTRITO_FEDERAL);
		 * documentoCliente2.setClienteDocumento(cliente2);
		 * 
		 * DocumentoCliente documentoCliente3 = new DocumentoCliente();
		 * documentoCliente3.setTipoCliente(TipoCliente.JURIDICA);
		 * documentoCliente3.setCpfCnpjCliente("31895910000103");
		 * documentoCliente3.setNaturalidadeRgCliente("São Paulo");
		 * documentoCliente3.setNomeMaeRgCliente("Maria Claudia Castro");
		 * documentoCliente3.setNomePaiRgCliente("Jose Carlos Castro");
		 * documentoCliente3.setNumeroRgCliente("426530238");
		 * documentoCliente3.setDataExpedicaoRgCliente(new Date(13 - 06 - 2012));
		 * documentoCliente3.setDataNascimentoRgCliente(new Date(13 - 06 - 2012));
		 * documentoCliente3.setOrgaoEmissorRgCliente("sba");
		 * documentoCliente3.setUfRgCliente(UnidadeFederacao.DISTRITO_FEDERAL);
		 * documentoCliente3.setClienteDocumento(cliente3);
		 * 
		 * DocumentoCliente documentoCliente4 = new DocumentoCliente();
		 * documentoCliente4.setTipoCliente(TipoCliente.JURIDICA);
		 * documentoCliente4.setCpfCnpjCliente("13212487000118");
		 * documentoCliente4.setNaturalidadeRgCliente("São Paulo");
		 * documentoCliente4.setNomeMaeRgCliente("Maria Claudia Castro");
		 * documentoCliente4.setNomePaiRgCliente("Jose Carlos Castro");
		 * documentoCliente4.setNumeroRgCliente("388839703");
		 * documentoCliente4.setDataExpedicaoRgCliente(new Date(13 - 06 - 2012));
		 * documentoCliente4.setDataNascimentoRgCliente(new Date(13 - 06 - 2012));
		 * documentoCliente4.setOrgaoEmissorRgCliente("sba");
		 * documentoCliente4.setUfRgCliente(UnidadeFederacao.DISTRITO_FEDERAL);
		 * documentoCliente4.setClienteDocumento(cliente4);
		 * 
		 * DocumentoCliente documentoCliente5 = new DocumentoCliente();
		 * documentoCliente5.setTipoCliente(TipoCliente.FISICA);
		 * documentoCliente5.setCpfCnpjCliente("51381182500");
		 * documentoCliente5.setNaturalidadeRgCliente("São Paulo");
		 * documentoCliente5.setNomeMaeRgCliente("Maria Claudia Castro");
		 * documentoCliente5.setNomePaiRgCliente("Jose Carlos Castro");
		 * documentoCliente5.setNumeroRgCliente("338938631");
		 * documentoCliente5.setDataExpedicaoRgCliente(new Date(13 - 06 - 2012));
		 * documentoCliente5.setDataNascimentoRgCliente(new Date(13 - 06 - 2012));
		 * documentoCliente5.setOrgaoEmissorRgCliente("sba");
		 * documentoCliente5.setUfRgCliente(UnidadeFederacao.DISTRITO_FEDERAL);
		 * documentoCliente5.setClienteDocumento(cliente5);
		 * 
		 * DocumentoCliente documentoCliente6 = new DocumentoCliente();
		 * documentoCliente6.setTipoCliente(TipoCliente.FISICA);
		 * documentoCliente6.setCpfCnpjCliente("17281510586");
		 * documentoCliente6.setNaturalidadeRgCliente("São Paulo");
		 * documentoCliente6.setNomeMaeRgCliente("Maria Claudia Castro");
		 * documentoCliente6.setNomePaiRgCliente("Jose Carlos Castro");
		 * documentoCliente6.setNumeroRgCliente("220397892");
		 * documentoCliente6.setDataExpedicaoRgCliente(new Date(13 - 06 - 2012));
		 * documentoCliente6.setDataNascimentoRgCliente(new Date(13 - 06 - 2012));
		 * documentoCliente6.setOrgaoEmissorRgCliente("sba");
		 * documentoCliente6.setUfRgCliente(UnidadeFederacao.DISTRITO_FEDERAL);
		 * documentoCliente6.setClienteDocumento(cliente6);
		 * 
		 * DocumentoCliente documentoCliente7 = new DocumentoCliente();
		 * documentoCliente7.setTipoCliente(TipoCliente.FISICA);
		 * documentoCliente7.setCpfCnpjCliente("79570355581");
		 * documentoCliente7.setNaturalidadeRgCliente("São Paulo");
		 * documentoCliente7.setNomeMaeRgCliente("Maria Claudia Castro");
		 * documentoCliente7.setNomePaiRgCliente("Jose Carlos Castro");
		 * documentoCliente7.setNumeroRgCliente("362535139");
		 * documentoCliente7.setDataExpedicaoRgCliente(new Date(13 - 06 - 2012));
		 * documentoCliente7.setDataNascimentoRgCliente(new Date(13 - 06 - 2012));
		 * documentoCliente7.setOrgaoEmissorRgCliente("sba");
		 * documentoCliente7.setUfRgCliente(UnidadeFederacao.DISTRITO_FEDERAL);
		 * documentoCliente7.setClienteDocumento(cliente7);
		 * 
		 * documentoService.salvaDocumentoCliente(documentoCliente1);
		 * documentoService.salvaDocumentoCliente(documentoCliente2);
		 * documentoService.salvaDocumentoCliente(documentoCliente3);
		 * documentoService.salvaDocumentoCliente(documentoCliente4);
		 * documentoService.salvaDocumentoCliente(documentoCliente5);
		 * documentoService.salvaDocumentoCliente(documentoCliente6);
		 * documentoService.salvaDocumentoCliente(documentoCliente7);
		 * 
		 * Login login1 = new Login(); login1.setLoginCliente("User1");
		 * login1.setSenhaCliente("qwertyuiop"); login1.setClienteLogin(cliente1);
		 * 
		 * Login login2 = new Login(); login2.setLoginCliente("User2");
		 * login2.setSenhaCliente("qwertyuiop"); login2.setClienteLogin(cliente2);
		 * 
		 * Login login3 = new Login(); login3.setLoginCliente("User3");
		 * login3.setSenhaCliente("qwertyuiop"); login3.setClienteLogin(cliente3);
		 * 
		 * Login login4 = new Login(); login4.setLoginCliente("User4");
		 * login4.setSenhaCliente("qwertyuiop"); login4.setClienteLogin(cliente4);
		 * 
		 * Login login5 = new Login(); login5.setLoginCliente("User5");
		 * login5.setSenhaCliente("qwertyuiop"); login5.setClienteLogin(cliente5);
		 * 
		 * Login login6 = new Login(); login6.setLoginCliente("User6");
		 * login6.setSenhaCliente("qwertyuiop"); login6.setClienteLogin(cliente6);
		 * 
		 * Login login7 = new Login(); login7.setLoginCliente("User7");
		 * login7.setSenhaCliente("qwertyuiop"); login7.setClienteLogin(cliente7);
		 * 
		 * loginService.savedByLogin(login1); loginService.savedByLogin(login2);
		 * loginService.savedByLogin(login3); loginService.savedByLogin(login4);
		 * loginService.savedByLogin(login5); loginService.savedByLogin(login6);
		 * loginService.savedByLogin(login7);
		 * 
		 * 
		 * Telefone telefone1 = new Telefone();
		 * telefone1.setCelularTelefone("11965743223");
		 * telefone1.setResidencialTelefone("1185547263");
		 * telefone1.setComercialTelefone("1185547263");
		 * telefone1.setClienteTelefone(cliente1);
		 * 
		 * Telefone telefone2 = new Telefone();
		 * telefone2.setCelularTelefone("11965743223");
		 * telefone2.setResidencialTelefone("1185547263");
		 * telefone2.setComercialTelefone("1185547263");
		 * telefone2.setClienteTelefone(cliente2);
		 * 
		 * Telefone telefone3 = new Telefone();
		 * telefone3.setCelularTelefone("11965743223");
		 * telefone3.setResidencialTelefone("1185547263");
		 * telefone3.setComercialTelefone("1185547263");
		 * telefone3.setClienteTelefone(cliente3);
		 * 
		 * Telefone telefone4 = new Telefone();
		 * telefone4.setCelularTelefone("11965743223");
		 * telefone4.setResidencialTelefone("1185547263");
		 * telefone4.setComercialTelefone("1185547263");
		 * telefone4.setClienteTelefone(cliente4);
		 * 
		 * Telefone telefone5 = new Telefone();
		 * telefone5.setCelularTelefone("11965743223");
		 * telefone5.setResidencialTelefone("1185547263");
		 * telefone5.setComercialTelefone("1185547263");
		 * telefone5.setClienteTelefone(cliente5);
		 * 
		 * Telefone telefone6 = new Telefone();
		 * telefone6.setCelularTelefone("11965743223");
		 * telefone6.setResidencialTelefone("1185547263");
		 * telefone6.setComercialTelefone("1185547263");
		 * telefone6.setClienteTelefone(cliente6);
		 * 
		 * Telefone telefone7 = new Telefone();
		 * telefone7.setCelularTelefone("11965743223");
		 * telefone7.setResidencialTelefone("1185547263");
		 * telefone7.setComercialTelefone("1185547263");
		 * telefone7.setClienteTelefone(cliente7);
		 * 
		 * telefoneService.salvaTelefone(telefone1);
		 * telefoneService.salvaTelefone(telefone2);
		 * telefoneService.salvaTelefone(telefone3);
		 * telefoneService.salvaTelefone(telefone4);
		 * telefoneService.salvaTelefone(telefone5);
		 * telefoneService.salvaTelefone(telefone6);
		 * telefoneService.salvaTelefone(telefone7);
		 */
		 

	}

}
