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

import com.google.common.base.Optional;
import com.qa.persistence.domain.TaskDomain;
import com.qa.persistence.dto.TaskDTO;
import com.qa.persistence.repos.TaskRepo;

@SpringBootTest
public class TaskServiceUnitTest {

	@MockBean // @Mock
	private ModelMapper MockMapper;
	@MockBean // @Mock
	private TaskRepo mockRepo;

	@Autowired // @injectMocks
	private TaskService service;
	
//	CRUD
	
	
	//Create
	
	@Test
	public void create() {
		
		TaskDomain TEST_TASK = new TaskDomain("Help Mum", "Helping", 5, false, null);
		TaskDTO DTOtest = new TaskDTO(1L, "Buy Banana", "Shopping", 2, false);

		Mockito.when(this.mockRepo.save(Mockito.any(TaskDomain.class))).thenReturn(TEST_TASK);
		Mockito.when(this.MockMapper.map(TEST_TASK, TaskDTO.class)).thenReturn(DTOtest);


		TaskDTO result = this.service.create(TEST_TASK);


		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).isEqualTo(DTOtest);
		Assertions.assertThat(result).usingRecursiveComparison()
		.isEqualTo(DTOtest);
		
		Mockito.verify(this.mockRepo, Mockito.times(1)).save(Mockito.any(TaskDomain.class));
		//should only run once
		Mockito.verify(this.MockMapper, Mockito.times(1)).map(TEST_TASK, TaskDTO.class);

	}
	
//	READ ONE
	
	
	
	@Test
	public void readOne() {
		
		TaskDomain TEST_TASK = new TaskDomain("Help Mum", "Helping", 5, false, null);
		TaskDTO DTOtest = new TaskDTO(1L, "Buy Banana", "Shopping", 2, false);

		Mockito.when(this.mockRepo.findById(TEST_TASK.getId())).thenReturn(Optional.of(TEST_TASK));

		Assertions.assertThat(this.service.readOne(DTOtest.getId())).isEqualTo(!true);

		Mockito.verify(this.mockRepo, Mockito.times(1)).deleteById(TEST_TASK.getId());
		Mockito.verify(this.mockRepo, Mockito.times(1)).existsById(TEST_TASK.getId());;

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