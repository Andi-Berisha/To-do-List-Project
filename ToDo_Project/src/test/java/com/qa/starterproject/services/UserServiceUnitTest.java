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
		// Resources
		UserDomain exampleUser = new UserDomain(1L, "Bob", "James", null);
		UserDTO userDto = new UserDTO(1L, "Bob", "James", null);

		// Rules
		Mockito.when(this.mockedRepo.save(Mockito.any(UserDomain.class))).thenReturn(exampleUser);
		Mockito.when(this.mapper.map(exampleUser, UserDTO.class)).thenReturn(userDto);

		// Actions
		UserDTO result = this.service.create(exampleUser);

		// Assertions
		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).isEqualTo(userDto);
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(userDto);

		Mockito.verify(this.mockedRepo, Mockito.times(1)).save(Mockito.any(UserDomain.class));
		Mockito.verify(this.mapper, Mockito.times(1)).map(exampleUser, UserDTO.class);

	}

	@Test
	public void readById() {
		// Resources
		UserDomain exampleUser = new UserDomain(1L, "Bob", "James", null);
		UserDTO userDto = new UserDTO(1L, "Bob", "James", null);

		// Rules
		Mockito.when(this.mapper.map(exampleUser, UserDTO.class)).thenReturn(userDto);
		Mockito.when(this.mockedRepo.findById(exampleUser.getId())).thenReturn(Optional.of(exampleUser));
		// Actions
		UserDTO result = this.service.readById(1L);

		// Assertions
		Assertions.assertThat(result).isEqualTo(userDto);
		Mockito.verify(this.mockedRepo, Mockito.times(1)).findById(1L);
	}
    
	
    
	@Test
	public void readAll() {
		// RESOURCES 
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

		// RULES
		Mockito.when(this.mapper.map(exampleUserA, UserDTO.class)).thenReturn(userDtoA);
		Mockito.when(this.mapper.map(exampleUserB, UserDTO.class)).thenReturn(userDtoB);
		Mockito.when(this.mockedRepo.findAll()).thenReturn(UserDomainList);

		// ACTIONS 
		List<UserDTO> result = this.service.readAll();

		// ASSERTIONS
		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).isEqualTo(UserListDto);
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(UserListDto);

		Mockito.verify(this.mapper, Mockito.times(1)).map(exampleUserA, UserDTO.class);
		Mockito.verify(this.mapper, Mockito.times(1)).map(exampleUserB, UserDTO.class);
		Mockito.verify(this.mockedRepo, Mockito.times(1)).findAll();}
		
		@Test
		public void delete() {
			// RESOURCES
			UserDomain exampleUser = new UserDomain(1L, "Henry", "Hoover", null);

			// RULES
			Mockito.when(this.mockedRepo.existsById(1L)).thenReturn(false);

			// ACTIONS
			boolean result = this.service.delete(1L);

			// ASSERTIONS
			Assertions.assertThat(result).isTrue();

			Mockito.verify(this.mockedRepo, Mockito.times(1)).deleteById(1L);

		}
}
		