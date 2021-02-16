package com.qa.starterproject.rest;




import java.util.ArrayList;
import java.util.List;



import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.starterproject.persistence.domain.TaskDomain;
import com.qa.starterproject.persistence.domain.UserDomain;
import com.qa.starterproject.persistence.dtos.TaskDTO;
import com.qa.starterproject.persistence.dtos.UserDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema-test.sql","classpath:data-test.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles="test")
class UserControllerIntegrationTest {
	
	@Autowired
	private MockMvc mock;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ObjectMapper jsonifier;
	
	private final int ID = 4;
	
	
	List<TaskDomain> tasksDomain = new ArrayList<>();
	List<TaskDTO> tasks = new ArrayList<>();
	
	private UserDTO mapToDTO(UserDomain model) {
		return this.mapper.map(model, UserDTO.class); 
	}
	
	
	
	
	@Test
	public void read() throws Exception{
		
		
		UserDTO expectedOutcome = new UserDTO(4L, "John", "Behar",tasks);
		// Set up the request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.GET, "http://localhost:8081/user/read/" + ID);
		
	// set up expectations
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(jsonifier.writeValueAsString(expectedOutcome));
		
	//Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
}
	
	
	

	@Test
	public void create() throws Exception{
		
		UserDomain contentBody = new UserDomain(1L, "Eni", "Berisha", tasksDomain); 
		UserDTO expectedOutcome = mapToDTO(contentBody);
		
		// Set up the request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "http://localhost:8081/user/create")
		.contentType(MediaType.APPLICATION_JSON).content(jsonifier.writeValueAsString(contentBody)).accept(MediaType.APPLICATION_JSON);
		
		// set up expectations
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedOutcome));
		
		//Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
			
}
	
	@Test
	public void update() throws Exception{
		
		UserDomain contentBody = new UserDomain(1L, "Nando","Palipana", tasksDomain);
		UserDTO expectedOutput = mapToDTO(contentBody);
		
		// Set up the request
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT,"http://localhost:8081/user/update/" + 1)
				.contentType(MediaType.APPLICATION_JSON).content(jsonifier.writeValueAsString(contentBody)).accept(MediaType.APPLICATION_JSON);
		
		// set up expectations
		
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedOutput));
		
		//Perform
		
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	
			
}
	
	@Test
	public void delete() throws Exception{
		
		// Set up the request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE, "http://localhost:8081/user/delete/" + ID);
		// set up expectations
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isNoContent();
		//Perform
		this.mock.perform(mockRequest).andExpect(matchStatus);
	
}
	
	
}