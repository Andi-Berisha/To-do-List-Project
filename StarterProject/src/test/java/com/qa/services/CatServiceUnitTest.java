package com.qa.services;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.starterprojects.persistence.domain.CatDomain;
import com.qa.starterprojects.persistence.domain.HouseDomain;
import com.qa.starterprojects.persistence.dtos.CatDTO;
import com.qa.starterprojects.persistence.repos.CatRepo;
import com.qa.starterprojects.services.CatService;

//inject mockito



@SpringBootTest
public class CatServiceUnitTest {
	
	@MockBean
	private ModelMapper mockedMapper;

	@MockBean
	private CatRepo mockedRepo;


	@Autowired
	private CatService service;


	public void create(CatDomain cat) {
		//Resources
		CatDomain Test_Cat= new CatDomain(1L,"Molly",4,2L,null); 
		//Rules
		Mockito.when(this.mockedRepo.save(Mockito.any(CatDomain.class))).thenReturn(Test_Cat);
		
		//Actions
		CatDTO result = this.service.create(Test_Cat);
		
		//Assertions
        Assertions.assertThat(result).isEqualTo(this.mockedMapper.map(Test_Cat,CatDTO.class));
	}

//	public void readAll() {
//	}
//	
//	public void readOne() {
//		//Resources
//				CatDomain Test_Cat= new CatDomain(1L,"Molly",2,4L,null); 
//				CatDTO Test_DTO = this.mockedMapper.map(Test_Cat, null);
//				//Rules
//				Mockito.when(this.mockedRepo.findById(Test_Cat.getId()).orElseThrow()).thenReturn(Optional.of(Test_Cat,CatDTO.class));
//				
//				//Actions
//				CatDTO result = this.service.readOne(1L);
//				
//				//Assertions
//		        Assertions.assertThat(result).isEqualTo(this.mockedMapper.map.(Test_Cat,CatDTO.class));
//		
//	}
//
//	public CatDTO update() {
//
//	}
//
//	public boolean delete(Long id) {
//	}

}
