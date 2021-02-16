package com.qa.rest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.persistence.domain.TaskDomain;
import com.qa.persistence.dto.TaskDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:schema-test.sql",
		"classpath:data-test.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class TaskControllerIntegrationTest {

	@Autowired
	private MockMvc mock;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private ObjectMapper jsonifier;



	private TaskDTO mapToDTO(TaskDomain model) {
		return this.mapper.map(model, TaskDTO.class);
	}

	// READ ALL TASKS
	@Test
	public void readAll() throws Exception {
		
		TaskDTO task1 = new TaskDTO(1L, "Buy Banana", "Shopping", 2, false);
		TaskDTO task2 = new TaskDTO(2L, "Football", "Sport", 3, true);
		TaskDTO task3 = new TaskDTO(3L, "Buy Phone", "Shopping", 2, false);
		TaskDTO task4 = new TaskDTO(4L, "Clean", "To Do", 3, true);
		TaskDTO task5 = new TaskDTO(5L, "Run", "Health", 2, false);
		TaskDTO task6 = new TaskDTO(6L,"Finish Report", "Work", 3, true);
		
				
		
		List<TaskDTO> expectedList = new ArrayList<>();
		expectedList.add(task1);
		expectedList.add(task2);
		expectedList.add(task3);
		expectedList.add(task4);
		expectedList.add(task5);
		expectedList.add(task6);

		// Request setup
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				"/task/readAll");

		// Expectations setup
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedList));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);

	}

	// read one task test
	@Test
	public void readTask() throws Exception {

		// EXPECTED INFO BACK WHICH WILL BE JSON
		TaskDTO expectedResults = new TaskDTO(1L, "Buy Banana", "Shopping", 2, false);

		// this sets up the request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				"/task/read/" + 1L);

		// CHECK STATUS THAT YOU GET
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();

		// CHECK IF YOU GET ONE task
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(jsonifier.writeValueAsString(expectedResults));
		// PERFORM THE ABOVE
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);

	}

	// creating task test
	@Test
	public void create() throws Exception {
		// EXPECTED INFO BACK WHICH WILL BE JSON

		TaskDomain contentBody = new TaskDomain("Help Mum", "Helping", 5, false, null);
		TaskDTO expectedResults = mapToDTO(contentBody); // EXPECTED RESULT
		expectedResults.setId(7L);

		// this sets up the request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.POST, "/task/create").contentType(MediaType.APPLICATION_JSON)
				.content(jsonifier.writeValueAsString(contentBody))
				.accept(MediaType.APPLICATION_JSON);

		// CHECK STATUS THAT YOU GET
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();

		// CHECK IF YOU CREATED TASK
		ResultMatcher matchConent = MockMvcResultMatchers.content()
				.json(jsonifier.writeValueAsString(expectedResults));

		// PERFORM THE ABOVE
		this.mock.perform(mockRequest)
		.andExpect(matchStatus)
		.andExpect(matchConent);
	}

	// updating task test
	@Test
	public void update() throws Exception {
		
		TaskDomain contentBody = new TaskDomain(1L, "Help Mum", "Helping", 5, false, null);
		TaskDTO expectedResults = mapToDTO(contentBody); // EXPECTED RESULT
		
		//THE request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.PUT, "/task/update/" + 1L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonifier.writeValueAsString(contentBody))
				.accept(MediaType.APPLICATION_JSON);
		
		//THE expectations
		ResultMatcher matchStatus = MockMvcResultMatchers.status()
				.isAccepted();
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(jsonifier.writeValueAsString(expectedResults));

		//Perform
		this.mock.perform(mockRequest)
		.andExpect(matchStatus)
		.andExpect(matchContent);

	}

	// delete task test successful
	@Test
	public void delete() throws Exception {

		// this sets up the request
		// we are going to delete ID 2
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.DELETE,
				"/task/delete/" + 2);

		// CHECK STATUS THAT YOU GET
		//the delete returns badrequest 
		ResultMatcher matchStatus = MockMvcResultMatchers.status()
				.isNoContent();

		// PERFORM THE ABOVE
		this.mock.perform(mockRequest)
		.andExpect(matchStatus);

	}

	// delete task test exception
	@Test
	public void deleteInternalError() throws Exception {

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				"/task/delete/" + 10);

		ResultMatcher internalerror = MockMvcResultMatchers.status().isInternalServerError();
		this.mock.perform(mockRequest)
		.andExpect(internalerror);

	}

}
