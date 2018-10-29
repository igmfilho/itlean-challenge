package com.github.igmfilho.challenge.itlean.dao.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.igmfilho.challenge.itlean.dao.model.PhoneEntity;
import com.github.igmfilho.challenge.itlean.dao.model.UserEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private UserRepository repository;
	
	@Test
	public void whenFindByEmail_thenReturnUser() {
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
	 
	    // when
	    UserEntity found = repository.findByEmail(expectedUser.getEmail());
	 
	    // then
        assertThat(found.getId()).isEqualTo(expectedUser.getId());
        assertThat(found.getName()).isEqualTo(expectedUser.getName());
        assertThat(found.getEmail()).isEqualTo(expectedUser.getEmail());
        assertThat(found.getPassword()).isEqualTo(expectedUser.getPassword());
        assertThat(found.getToken()).isEqualTo(expectedUser.getToken());
        assertThat(found.getPhones()).isEqualTo(expectedUser.getPhones());
        
        assertThat(found.getCreated()).isEqualTo(expectedUser.getCreated());
        assertThat(found.getModified()).isEqualTo(expectedUser.getModified());
        assertThat(found.getLastSignin()).isEqualTo(expectedUser.getLastSignin());
	}
	
    @Test
    public void whenSave_thenStoreUser() {
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

        // when
        UserEntity saved = repository.save(expectedUser);

        // then
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getId()).isGreaterThan(0L);
        assertThat(saved.getName()).isEqualTo(expectedUser.getName());
        assertThat(saved.getEmail()).isEqualTo(expectedUser.getEmail());
        assertThat(saved.getPassword()).isEqualTo(expectedUser.getPassword());
        assertThat(saved.getToken()).isEqualTo(expectedUser.getToken());
        assertThat(saved.getPhones()).isEqualTo(expectedUser.getPhones());
        
        assertThat(saved.getCreated()).isEqualTo(expectedUser.getCreated());
        assertThat(saved.getModified()).isEqualTo(expectedUser.getModified());
        assertThat(saved.getLastSignin()).isEqualTo(expectedUser.getLastSignin());
    }
}