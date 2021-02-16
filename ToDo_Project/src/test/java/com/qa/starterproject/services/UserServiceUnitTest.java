package com.qa.starterproject.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.qa.starterproject.persistence.domain.UserDomain;

import com.qa.starterproject.persistence.dtos.UserDTO;

import com.qa.starterproject.persistence.repos.UserRepo;

@SpringBootTest
public class UserServiceUnitTest {

	@MockBean
	private ModelMapper mapper;

	@MockBean
	private UserRepo mockedRepo;

	@Autowired
	private UserService service;

	@Test
	public void create() {
		// Resources employed
		UserDomain exampleUser = new UserDomain(1L, "Bob", "James", null);
		UserDTO userDto = new UserDTO(1L, "Bob", "James", null);

		// Rules set
		Mockito.when(this.mockedRepo.save(Mockito.any(UserDomain.class))).thenReturn(exampleUser);
		Mockito.when(this.mapper.map(exampleUser, UserDTO.class)).thenReturn(userDto);

		// Actions performed 
		UserDTO result = this.service.create(exampleUser);

		// Assertions made
		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).isEqualTo(userDto);
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(userDto);

		Mockito.verify(this.mockedRepo, Mockito.times(1)).save(Mockito.any(UserDomain.class));
		Mockito.verify(this.mapper, Mockito.times(1)).map(exampleUser, UserDTO.class);

	}

	@Test
	public void readById() {
		// Resources Employed
		UserDomain exampleUser = new UserDomain(1L, "Bob", "James", null);
		UserDTO userDto = new UserDTO(1L, "Bob", "James", null);

		// Rules set
		Mockito.when(this.mapper.map(exampleUser, UserDTO.class)).thenReturn(userDto);
		Mockito.when(this.mockedRepo.findById(exampleUser.getId())).thenReturn(Optional.of(exampleUser));
		// Actions performed
		UserDTO result = this.service.readById(1L);

		// Assertions made
		Assertions.assertThat(result).isEqualTo(userDto);
		Mockito.verify(this.mockedRepo, Mockito.times(1)).findById(1L);
	}
    
	
    
	@Test
	public void readAll() {
		// Resources Employed
		UserDomain exampleUserA = new UserDomain(1L, "Bob", "James", null);
		UserDomain exampleUserB = new UserDomain(1L, "Danny", "Philips", null);
		List<UserDomain> UserDomainList = new ArrayList<>();
		UserDomainList.add(exampleUserA);
		UserDomainList.add(exampleUserB);

		UserDTO userDtoA = new UserDTO(1L, "Bob", "James", null);
		UserDTO userDtoB = new UserDTO(1L, "Danny", "Phillips", null);
		List<UserDTO> UserListDto = new ArrayList<>();
		UserListDto.add(userDtoA);
		UserListDto.add(userDtoB);

		// Rules set
		Mockito.when(this.mapper.map(exampleUserA, UserDTO.class)).thenReturn(userDtoA);
		Mockito.when(this.mapper.map(exampleUserB, UserDTO.class)).thenReturn(userDtoB);
		Mockito.when(this.mockedRepo.findAll()).thenReturn(UserDomainList);

		// Actions performed
		List<UserDTO> result = this.service.readAll();

		// Assertions made
		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).isEqualTo(UserListDto);
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(UserListDto);

		Mockito.verify(this.mapper, Mockito.times(1)).map(exampleUserA, UserDTO.class);
		Mockito.verify(this.mapper, Mockito.times(1)).map(exampleUserB, UserDTO.class);
		Mockito.verify(this.mockedRepo, Mockito.times(1)).findAll();}
	
	@Test
	public void update() {
		// Resources Employed
		UserDomain exampleDomain = new UserDomain(1L, "Andi", "Berisha",null);
		UserDTO exampleDTO = new UserDTO(1L, "Andi", "Berisha", null);

		Long id = 1L;

		// Rules set
		Mockito.when(this.mockedRepo.findById(exampleDomain.getId())).thenReturn(Optional.of(exampleDomain));
		Mockito.when(this.mockedRepo.save(Mockito.any(UserDomain.class))).thenReturn(exampleDomain);
		Mockito.when(this.mapper.map(exampleDomain, UserDTO.class)).thenReturn(exampleDTO);

		// Actions performed
		UserDTO result = this.service.update(id, exampleDomain);

		// Assertions made
		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).isEqualTo(exampleDTO);
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(exampleDTO);

		Mockito.verify(this.mockedRepo, Mockito.times(1)).findById(id);
		Mockito.verify(this.mockedRepo, Mockito.times(1)).save(exampleDomain);
		Mockito.verify(this.mapper, Mockito.times(1)).map(exampleDomain, UserDTO.class);

	}
		
		@Test
		public void delete() {
			// Resources Employed
			UserDomain exampleUser = new UserDomain(1L, "Henry", "Hoover", null);

			// Rules set
			Mockito.when(this.mockedRepo.existsById(1L)).thenReturn(false);

			// Actions performed
			boolean result = this.service.delete(1L);

			// Assertions made
			Assertions.assertThat(result).isTrue();

			Mockito.verify(this.mockedRepo, Mockito.times(1)).deleteById(1L);

		}
}
		