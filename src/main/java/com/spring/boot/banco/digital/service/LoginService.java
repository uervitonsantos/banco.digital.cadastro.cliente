/**
 * 
 */
package com.spring.boot.banco.digital.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.boot.banco.digital.model.Login;
import com.spring.boot.banco.digital.repository.LoginRepository;

/**
 * @author uerviton-santos
 *
 */

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	

	public List<Login> findAllByLogin() {
		return loginRepository.findAll();
	}

	

}
