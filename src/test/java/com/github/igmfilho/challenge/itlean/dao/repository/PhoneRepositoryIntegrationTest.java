package com.github.igmfilho.challenge.itlean.dao.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.igmfilho.challenge.itlean.dao.model.PhoneEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PhoneRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private PhoneRepository repository;
    
    @Test
    public void whenFindById_thenReturnPhone() {
        // given
        PhoneEntity expectedPhone = new PhoneEntity();
        expectedPhone.setDdd(21);
        expectedPhone.setNumber(22212221);
        
        entityManager.persist(expectedPhone);
        entityManager.flush();
     
        // when
        PhoneEntity found = repository.findOne(expectedPhone.getId());
     
        // then
        assertThat(found.getDdd()).isEqualTo(expectedPhone.getDdd());
        assertThat(found.getNumber()).isEqualTo(expectedPhone.getNumber());
    }
    
    @Test
    public void whenSave_thenStorePhone() {
        // given
        PhoneEntity expectedPhone = new PhoneEntity();
        expectedPhone.setDdd(21);
        expectedPhone.setNumber(22212221);

        // when
        PhoneEntity saved = repository.save(expectedPhone);

        // then
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getId()).isGreaterThan(0L);
        assertThat(saved.getDdd()).isEqualTo(expectedPhone.getDdd());
        assertThat(saved.getNumber()).isEqualTo(expectedPhone.getNumber());
    }
}