package com.github.igmfilho.challenge.itlean.utility;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;

import com.github.igmfilho.challenge.itlean.api.model.PhoneDTO;
import com.github.igmfilho.challenge.itlean.api.model.UserDTO;
import com.github.igmfilho.challenge.itlean.dao.model.PhoneEntity;
import com.github.igmfilho.challenge.itlean.dao.model.UserEntity;

public class ConverterTest {

	@Test
	public void whenConvertUserEntity_thenReturnUserDto() {
	    // given
        PhoneEntity phone01 = new PhoneEntity();
        phone01.setId(1L);
        phone01.setDdd(21);
        phone01.setNumber(22212221);

        PhoneEntity phone02 = new PhoneEntity();
        phone02.setId(2L);
        phone02.setDdd(21);
        phone02.setNumber(99981234);
		
	    UserEntity userEntity = new UserEntity();
	    userEntity.setId(1L);
	    userEntity.setEmail("user.teste@domain.com");
	    userEntity.setName("Test's User");
	    userEntity.setPassword("xyz");
	    userEntity.setToken("123456");
	    userEntity.setPhones(Arrays.asList(phone01, phone02));

		Calendar icalendar = Calendar.getInstance();
		userEntity.setCreated(icalendar);
	    userEntity.setModified(icalendar);
	    userEntity.setLastSignin(icalendar);
	    
	    // when
	    UserDTO converted = Converter.fromEntity(userEntity);
	 
	    // then
        assertThat(converted.getId()).isEqualTo(userEntity.getId());
        assertThat(converted.getName()).isEqualTo(userEntity.getName());
        assertThat(converted.getEmail()).isEqualTo(userEntity.getEmail());
        assertThat(converted.getPassword()).isEqualTo(userEntity.getPassword());
        assertThat(converted.getToken()).isEqualTo(userEntity.getToken());
        
        assertThat(converted.getCreated()).isEqualTo(userEntity.getCreated());
        assertThat(converted.getModified()).isEqualTo(userEntity.getModified());
        assertThat(converted.getLastSignin()).isEqualTo(userEntity.getLastSignin());
        
        for (int i = 0; i < converted.getPhones().size(); i++) {
        	PhoneDTO dto = converted.getPhones().get(i);
        	PhoneEntity entity = userEntity.getPhones().get(i);
            assertThat(dto.getId()).isEqualTo(entity.getId());
            assertThat(dto.getDdd()).isEqualTo(entity.getDdd());
            assertThat(dto.getNumber()).isEqualTo(entity.getNumber());
		}
	}
	
	@Test
	public void whenConvertUserDto_thenReturnUserEntity() {
	    // given
        PhoneDTO phone01 = new PhoneDTO();
        phone01.setId(1L);
        phone01.setDdd(21);
        phone01.setNumber(22212221);

        PhoneDTO phone02 = new PhoneDTO();
        phone02.setId(2L);
        phone02.setDdd(21);
        phone02.setNumber(99981234);
		
	    UserDTO userDto = new UserDTO();
	    userDto.setId(1L);
	    userDto.setEmail("user.teste@domain.com");
	    userDto.setName("Test's User");
	    userDto.setPassword("xyz");
	    userDto.setToken("123456");
	    userDto.setPhones(Arrays.asList(phone01, phone02));

		Calendar icalendar = Calendar.getInstance();
		userDto.setCreated(icalendar);
	    userDto.setModified(icalendar);
	    userDto.setLastSignin(icalendar);
	    
	    // when
	    UserEntity converted = Converter.fromDto(userDto);
	 
	    // then
        assertThat(converted.getId()).isEqualTo(userDto.getId());
        assertThat(converted.getName()).isEqualTo(userDto.getName());
        assertThat(converted.getEmail()).isEqualTo(userDto.getEmail());
        assertThat(converted.getPassword()).isEqualTo(userDto.getPassword());
        assertThat(converted.getToken()).isEqualTo(userDto.getToken());
        
        assertThat(converted.getCreated()).isEqualTo(userDto.getCreated());
        assertThat(converted.getModified()).isEqualTo(userDto.getModified());
        assertThat(converted.getLastSignin()).isEqualTo(userDto.getLastSignin());
        
        for (int i = 0; i < converted.getPhones().size(); i++) {
        	PhoneEntity entity = converted.getPhones().get(i);
        	PhoneDTO dto = userDto.getPhones().get(i);
            assertThat(entity.getId()).isEqualTo(dto.getId());
            assertThat(entity.getDdd()).isEqualTo(dto.getDdd());
            assertThat(entity.getNumber()).isEqualTo(dto.getNumber());
		}
	}	
}