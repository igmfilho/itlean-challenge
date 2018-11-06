package com.github.igmfilho.challenge.itlean.service;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.igmfilho.challenge.itlean.SpringBootRestApiApplication;
import com.github.igmfilho.challenge.itlean.api.model.UserDTO;
import com.github.igmfilho.challenge.itlean.dao.model.PhoneEntity;
import com.github.igmfilho.challenge.itlean.dao.model.UserEntity;
import com.github.igmfilho.challenge.itlean.exception.EmailAlreadyRegisteredException;
import com.github.igmfilho.challenge.itlean.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRestApiApplication.class)
@DataJpaTest
public class UserServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
	private UserServiceImpl userService;

	@Before
	public void setUp() {
	    // given
        PhoneEntity phone01 = new PhoneEntity();
        phone01.setDdd(21);
        phone01.setNumber(22212221);

        PhoneEntity phone02 = new PhoneEntity();
        phone02.setDdd(21);
        phone02.setNumber(99981234);
		
	    UserEntity expectedUser = new UserEntity();
	    expectedUser.setEmail("user.teste@domain.com");
	    expectedUser.setName("Test's User");
	    expectedUser.setPassword("xyz");
	    expectedUser.setToken("123456");
	    expectedUser.setPhones(Arrays.asList(phone01, phone02));

		Calendar icalendar = Calendar.getInstance();
		expectedUser.setCreated(icalendar);
	    expectedUser.setModified(icalendar);
	    expectedUser.setLastSignin(icalendar);
	    
	    entityManager.persist(expectedUser);
	    entityManager.flush();
	}
    

	@Test(expected = EmailAlreadyRegisteredException.class)
	public void whenRegisterUserWithExistingEmail_thenThrowEmailAlreadyRegisteredException() {
		
		UserDTO user = new UserDTO();
		user.setEmail("user.teste@domain.com");
		
		//when
		userService.register(user);
		
	}

}
