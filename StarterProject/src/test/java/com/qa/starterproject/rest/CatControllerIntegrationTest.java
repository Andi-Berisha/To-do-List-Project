package com.qa.starterproject.rest;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.starterprojects.persistence.domain.CatDomain;
import com.qa.starterprojects.persistence.dtos.CatDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:data-test.sql"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles="test")
public class CatControllerIntegrationTest {
	
	@Autowired
	private MockMvc mock;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ObjectMapper jsonifier;
	
	private final int ID = 1;
	
	private CatDTO mapToDTO(CatDomain model) {
		return this.mapper.map(model, CatDTO.class);
	}
	
//	//create complete
//	@PostMapping("/create")
//	public void create(){
//		CatDomain contentBody = new CatDomain(1L,"Molly",2,4L,null);
//		CatDTO expectedResult =mapToDTO(contentBody);
//				// Set up the request
//				MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
//						.request(HttpMethod.GET, "localhost:8080/cat/create")
//						.contentType(MediaType.APPLICATION_JSON)
//						.accept(jsonifier.writeValueAsString(contentBody))
//						.accept(MediaType.APPLICATION_JSON);
//				
//			// set up expectations
//				ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
//				ResultMatcher matchContent = MockMvcResultMatchers.content()
//						.json(jsonifier.writeValueAsString(expectedResult));
//				
//			//Perform
//				this.mock.perform(mockRequest).andExpect(matchStatus)
//				.andExpect(matchContent);
//			}
		
		
		
	//read one
	@Test
	public void readCat() throws Exception {
		CatDTO expectedResult = new CatDTO(1L,"Tesla",4L);
		// Set up the request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.GET, "locakhost:8080/cat/read" + ID);
		
	// set up expectations
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(jsonifier.writeValueAsString(expectedResult));
		
	//Perform
		this.mock.perform(mockRequest).andExpect(matchStatus);
	}
	}
		
//	//read
//		@GetMapping("/readAll")
//		public void readAll(){
//			
//		}
//		
//	// Update
//		@PutMapping("/update")
//		public ResponseEntity<CatDTO> update(@PathVariable("id") Long id, @RequestBody CatDomain cat) {
//			return new ResponseEntity<CatDTO>(this.service.update(id, cat),HttpStatus.ACCEPTED);
//			
//		}
//		
//	// Delete
//		@DeleteMapping("/delete/{id}")
//		public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
//			return this.service.delete(id) ? 
//					new ResponseEntity<>(HttpStatus.NO_CONTENT):
//				    new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//
//}
