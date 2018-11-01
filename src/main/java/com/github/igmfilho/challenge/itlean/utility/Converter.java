package com.github.igmfilho.challenge.itlean.utility;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.github.igmfilho.challenge.itlean.api.model.PhoneDTO;
import com.github.igmfilho.challenge.itlean.api.model.UserDTO;
import com.github.igmfilho.challenge.itlean.dao.model.PhoneEntity;
import com.github.igmfilho.challenge.itlean.dao.model.UserEntity;

public class Converter {
	
	private final static Function<PhoneDTO, PhoneEntity> fromPhoneDto = new Function<PhoneDTO, PhoneEntity>() {
		@Override
		public PhoneEntity apply(PhoneDTO phoneDTO) {
		     
			PhoneEntity phoneEntity = new PhoneEntity();
		    phoneEntity.setId(phoneDTO.getId());
		    phoneEntity.setDdd(phoneDTO.getDdd());
		    phoneEntity.setNumber(phoneDTO.getNumber());
			
		    return phoneEntity;
		}
	};

	private final static Function<PhoneEntity, PhoneDTO> fromPhoneEntity = new Function<PhoneEntity, PhoneDTO>() {
		@Override
		public PhoneDTO apply(PhoneEntity phoneEntity) {
		     
			PhoneDTO phoneDTO = new PhoneDTO();
			phoneDTO.setId(phoneEntity.getId());
			phoneDTO.setDdd(phoneEntity.getDdd());
			phoneDTO.setNumber(phoneEntity.getNumber());
			
		    return phoneDTO;
		}
	};

	private final static Function<UserDTO, UserEntity> fromUserDto = new Function<UserDTO, UserEntity>() {
		@Override
		public UserEntity apply(UserDTO userDto) {
			
		    UserEntity userEntity = new UserEntity();
		    userEntity.setId(userDto.getId());
		    userEntity.setEmail(userDto.getEmail());
		    userEntity.setName(userDto.getName());
		    userEntity.setPassword(userDto.getPassword());
		    userEntity.setToken(userDto.getToken());
			userEntity.setCreated(userDto.getCreated());
		    userEntity.setModified(userDto.getModified());
		    userEntity.setLastSignin(userDto.getLastSignin());
		    
		    Optional<List<PhoneDTO>> phones = Optional.ofNullable(userDto.getPhones());
		    if(phones.isPresent()) {
		    	userEntity.setPhones(phones.get().stream()
		    			  .map(fromPhoneDto).collect(Collectors.toList()));
		    }
			return userEntity;
		}
	};

	private final static Function<UserEntity, UserDTO> fromUserEntity = new Function<UserEntity, UserDTO>() {
		@Override
		public UserDTO apply(UserEntity userEntity) {
			
			UserDTO userDto = new UserDTO();
		    userDto.setId(userEntity.getId());
		    userDto.setEmail(userEntity.getEmail());
		    userDto.setName(userEntity.getName());
		    userDto.setPassword(userEntity.getPassword());
		    userDto.setToken(userEntity.getToken());
			userDto.setCreated(userEntity.getCreated());
		    userDto.setModified(userEntity.getModified());
		    userDto.setLastSignin(userEntity.getLastSignin());
		    
		    Optional<List<PhoneEntity>> phones = Optional.ofNullable(userEntity.getPhones());
		    if(phones.isPresent()) {
		    	userDto.setPhones(phones.get().stream()
		    			  .map(fromPhoneEntity).collect(Collectors.toList()));
		    }
			return userDto;
		}
	};

	public static UserEntity fromDto(UserDTO userDto) {
		return fromUserDto.apply(userDto);
	}
	
	public static PhoneEntity fromDto(PhoneDTO phoneDTO) {
		return fromPhoneDto.apply(phoneDTO);
	}

	public static UserDTO fromEntity(UserEntity userEntity) {
		return fromUserEntity.apply(userEntity);
	}
	
	public static PhoneDTO fromEntity(PhoneEntity phoneEntity) {
		return fromPhoneEntity.apply(phoneEntity);
	}
}