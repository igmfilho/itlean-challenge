package com.github.igmfilho.challenge.itlean.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.igmfilho.challenge.itlean.api.model.UserDTO;
import com.github.igmfilho.challenge.itlean.dao.model.UserEntity;
import com.github.igmfilho.challenge.itlean.dao.repository.UserRepository;
import com.github.igmfilho.challenge.itlean.exception.EmailAlreadyRegisteredException;
import com.github.igmfilho.challenge.itlean.service.UserService;
import com.github.igmfilho.challenge.itlean.utility.Converter;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;	
	
	@Override
	public UserDTO register(UserDTO user) {
		
		if(userRepository.findByEmail(user.getEmail())!= null) {
			throw new EmailAlreadyRegisteredException();
		}
		UserEntity userEntity = Converter.fromDto(user);
		

		String passwordEncoded = passwordEncoder.encode(user.getPassword()); 
		System.out.println("ENCODED : " + passwordEncoded);
		
		return null;
	}

}
