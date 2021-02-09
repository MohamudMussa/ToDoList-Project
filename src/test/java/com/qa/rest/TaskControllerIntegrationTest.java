package com.qa.rest;

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

	private final int ID = 1;

	private TaskDTO mapToDTO(TaskDomain model) {
		return this.mapper.map(model, TaskDTO.class);
	}

	// READ ALL TASKS
	@Test
	public void readAll() throws Exception {

	}

	//read one task test
	@Test
	public void readTask() throws Exception {
		
        // EXPECTED INFO BACK WHICH WILL BE JSON
        TaskDTO expectedResults = new TaskDTO(1L, "Buy Banana", "Shopping", 2, false);

        // this sets up the request
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
                "http://localhost:8080/task/read/" + ID);

        // CHECK STATUS THAT YOU GET
        ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();

        // CHECK IF YOU GET ONE TASK
        ResultMatcher matchConent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedResults));

        // PERFORM THE ABOVE
        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchConent);
	}
	
	
	//creating task test
	@Test
	public void create() throws Exception {
        // EXPECTED INFO BACK WHICH WILL BE JSON

        TaskDomain contentBody = new TaskDomain("Help Mum", "Helping", 5, false, null);
        TaskDTO expectedResults = mapToDTO(contentBody); // EXPECTED RESULT
        expectedResults.setId(7L);

        // this sets up the request
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .request(HttpMethod.POST, "http://localhost:8080/task/create").contentType(MediaType.APPLICATION_JSON)
                .content(jsonifier.writeValueAsString(contentBody)).accept(MediaType.APPLICATION_JSON);

        // CHECK STATUS THAT YOU GET
        ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();

        // CHECK IF YOU CREATED TASK
        ResultMatcher matchConent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedResults));

        // PERFORM THE ABOVE
        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchConent);
	}

	//updating task test
	@Test
	public void update() throws Exception {
		
		

	}

	//delete task test successful
	@Test
	public void delete() throws Exception {
		
        // this sets up the request
        // we are going to delete ID 2
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
                "http://localhost:8080/task/delete/" + 2);

        // CHECK STATUS THAT YOU GET
        ResultMatcher matchStatus = MockMvcResultMatchers.status().isNoContent();

        // PERFORM THE ABOVE
        this.mock.perform(mockRequest).andExpect(matchStatus);

	}
	//delete task test exception
	@Test
	public void deleteInternalError() throws Exception {

            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
                    "http://localhost:8080/task/delete/" + 5);

            ResultMatcher nonMatch = MockMvcResultMatchers.status().isInternalServerError();
            this.mock.perform(mockRequest).andExpect(nonMatch);

	}

}
