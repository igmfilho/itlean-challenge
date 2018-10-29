package com.github.igmfilho.challenge.itlean.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.igmfilho.challenge.itlean.api.model.UserDTO;
import com.github.igmfilho.challenge.itlean.dao.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;	
	
	@Override
	public UserDTO register(UserDTO user) {

		String passwordEncoded = bCryptPasswordEncoder.encode(user.getPassword()); 
		System.out.println("ENCODED : " + passwordEncoded);
		
		return null;
	}

}
