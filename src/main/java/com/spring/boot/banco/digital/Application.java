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
import com.spring.boot.banco.digital.model.Endereco;
import com.spring.boot.banco.digital.model.Login;
import com.spring.boot.banco.digital.model.PessoaFisica;
import com.spring.boot.banco.digital.model.Telefone;
import com.spring.boot.banco.digital.service.ClienteService;
import com.spring.boot.banco.digital.service.EnderecoService;
import com.spring.boot.banco.digital.service.LoginService;
import com.spring.boot.banco.digital.service.TelefoneService;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class })
public class Application implements CommandLineRunner {

	@Autowired
	ClienteService clienteService;

	@Autowired
	EnderecoService enderecoService;

	@Autowired
	LoginService loginService;

	@Autowired
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

		PessoaFisica cliente1 = new PessoaFisica();
		cliente1.setNomeCliente("Carlos");
		cliente1.setSobrenomeCliente("Machado");
		cliente1.setEmailCliente("carlos.machado@gmail.com");
		cliente1.setCpfCnpjCliente("37344438810");
		cliente1.setSexoCliente(SexoCliente.MASCULINO);
		cliente1.setAtivoCliente(true);
		cliente1.setTipoCliente(TipoCliente.FISICA);
		cliente1.setNumeroRgCliente("362535139");
		cliente1.setOrgaoEmissorRgCliente("SSP");
		cliente1.setUfRgCliente(UnidadeFederacao.SAO_PAULO);
		cliente1.setNaturalidadeRgCliente("Bahia");
		cliente1.setDataNascimentoRgCliente(new Date(15 - 06 - 1982));
		cliente1.setNomeMaeRgCliente("Maria Cristina Rosa");
		cliente1.setNomePaiRgCliente("Fabio Alves Machado");
		cliente1.setDataExpedicaoRgCliente(new Date(13 - 06 - 2012));

		clienteService.salvaCliente(cliente1);
		

		Endereco endereco1 = new Endereco();
		endereco1.setRuaEndereco("Rua Amazonas");
		endereco1.setNumeroEndereco("23");
		endereco1.setBairroEndereco("Alvorada");
		endereco1.setMunicipioEndereco("Alvorada");
		endereco1.setCidadeEndereco("Manaus");
		endereco1.setEstadoEndereco("AM");
		endereco1.setUfEndereco(UnidadeFederacao.AMAZONAS);
		endereco1.setCepEndereco("08566788");
		endereco1.setClienteEnderecos(cliente1);

		enderecoService.salvaEndereco(endereco1);

		Login login1 = new Login();
		login1.setLoginCliente("User1");
		login1.setSenhaCliente("qwertyuiop");
		login1.setClienteLogin(cliente1);

		loginService.savedByLogin(login1);

		Telefone telefone1 = new Telefone();
		telefone1.setCelularTelefone("11965743223");
		telefone1.setResidencialTelefone("1185547263");
		telefone1.setComercialTelefone("1185547263");
		telefone1.setClienteTelefone(cliente1);

		telefoneService.salvaTelefone(telefone1);

	}

}
