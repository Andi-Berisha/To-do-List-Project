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

import com.qa.starterproject.persistence.dtos.TaskDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema-test.sql","classpath:data-test.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles="test")
class TaskControllerIntegrationTest {
	
	@Autowired
	private MockMvc mock;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ObjectMapper jsonifier;
	
	private final int ID = 1;
	
	private TaskDTO mapToDTO(TaskDomain model) {
		return this.mapper.map(model, TaskDTO.class); 
	}
	
	


	@Test
	public void read() throws Exception{
		
		
		TaskDTO expectedResult = new TaskDTO(1L,"taxes",true);
		// Set up the request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.GET, "http://localhost:8081/task/read/" + ID);
		
	// set up expectations
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(jsonifier.writeValueAsString(expectedResult));
		
	//Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
}
	
	@Test
	public void delete() throws Exception{
		
		// Set up the request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE, "http://localhost:8081/task/delete/" + ID);
		// set up expectations
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isNoContent();
		//Perform
		this.mock.perform(mockRequest).andExpect(matchStatus);
	
}
	
	
	@Test
	public void create() throws Exception{
		
		TaskDomain contentBody = new TaskDomain(1L, "washing up", true, null); 
		TaskDTO expectedResult = mapToDTO(contentBody);
		
		// Set up the request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "http://localhost:8081/task/create")
		.contentType(MediaType.APPLICATION_JSON).content(jsonifier.writeValueAsString(contentBody)).accept(MediaType.APPLICATION_JSON);
		
		// set up expectations
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedResult));
		
		//Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
			
}
	
	@Test
	public void update() throws Exception{
		
		TaskDomain contentBody = new TaskDomain(1L, "wash car",true, null);
		TaskDTO expectedResult = mapToDTO(contentBody);
		
		// Set up the request
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT,"http://localhost:8081/task/update/" + ID)
				.contentType(MediaType.APPLICATION_JSON).content(jsonifier.writeValueAsString(contentBody)).accept(MediaType.APPLICATION_JSON);
		
		// set up expectations
		
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedResult));
		
		//Perform
		
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	
}
	@Test
	public void readAll() throws Exception{
		
		
		TaskDTO OutputExpected1 = new TaskDTO(1L, "taxes",true);
		TaskDTO OutputExpected2 = new TaskDTO(2L, "Laundry", true);
		TaskDTO OutputExpected3 = new TaskDTO(3L, "Walk the dog", false);
		
		List<TaskDTO>taskDTOList = new ArrayList<TaskDTO>();
		
		taskDTOList.add(OutputExpected1);
		taskDTOList.add(OutputExpected2);
		taskDTOList.add(OutputExpected3);
	
		
		// Set up the request
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "http://localhost:8081/task/readAll").accept(org.springframework.http.MediaType.APPLICATION_JSON);
		
		// set up expectations
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(taskDTOList));
		
		//Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
		
		
	}
	
	
	
}

