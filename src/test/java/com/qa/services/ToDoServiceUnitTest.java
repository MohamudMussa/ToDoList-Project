package com.qa.services;


import java.util.ArrayList;
import java.util.List;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.qa.persistence.domain.TaskDomain;
import com.qa.persistence.dto.TaskDTO;
import com.qa.persistence.repos.TaskRepo;

@SpringBootTest
public class ToDoServiceUnitTest {

	@MockBean // @Mock
	private ModelMapper MockMapper;
	@MockBean // @Mock
	private TaskRepo mockRepo;

	@Autowired // @injectMocks
	private TaskService service;
	
//	CRUD
	
	
	//CREAD
	
	@Test
	public void create() {

	}
	
//	READ ONE
	
	
	
	@Test
	public void readTask() {

	}
	
//	READ ALL
	@Test
	public void readAll() {

	}
	
	
//	DELETE
	@Test
	public void delete() {

	}
	
}