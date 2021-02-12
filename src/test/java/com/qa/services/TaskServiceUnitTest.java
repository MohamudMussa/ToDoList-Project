package com.qa.services;


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
		
		//needed info
		TaskDomain TEST_TASK = new TaskDomain("Help Mum", "Helping", 5, false, null);
		TaskDTO DTOtest = new TaskDTO(1L, "Buy Banana", "Shopping", 2, false);

		//rule
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
		
		TaskDomain test_task = new TaskDomain(1L, "Help Mum", "Helping", 5, false, null);
		TaskDTO test_dto = this.MockMapper.map(test_task, TaskDTO.class);
		
		//the rules
		Mockito.when(this.mockRepo.findById(test_task.getId())).thenReturn(Optional.of(test_task));
		
		//the task
		TaskDTO result = this.service.readOne(1L);

		
		Assertions.assertThat(result).isEqualTo(test_dto);
		//should only run once
		Mockito.verify(this.mockRepo, Mockito.times(1)).findById(1L);
		
		

	}
	
//	READ ALL
	
	@Test
	public void readAll() {
		
		TaskDomain testTask = new TaskDomain(1L, "Help Mum", "Helping", 5, false, null);
//		TaskDomain testTaskTwo = new TaskDomain(1L, "Help Mum", "Helping", 5, false, null);
//		TaskDomain testTaskThree = new TaskDomain(1L, "Help Mum", "Helping", 5, false, null);
		List<TaskDomain> testList =  new ArrayList<>();
		testList.add(testTask);
//		testList.add(testTaskTwo);
//		testList.add(testTaskThree);
		
		TaskDTO testDTO = new TaskDTO(1L, "Buy Banana", "Shopping", 2, false);
		List<TaskDTO> testDTOList = new ArrayList<>();
		testDTOList.add(testDTO);

		// Rules
		Mockito.when(this.mockRepo.findAll() ).thenReturn(testList);
		Mockito.when(this.MockMapper.map(testTask, TaskDTO.class)).thenReturn(testDTO);

		// Actions

		List<TaskDTO> result = this.service.readAll();

		// Assertions

		Assertions.assertThat(result).usingRecursiveComparison()
		.isEqualTo(testDTOList);
		

	}
	
	
//	DELETE
	@Test
	public void delete() {
		
		//resources
		TaskDomain test_task = new TaskDomain(1L, "Help Mum", "Helping", 5, false, null);
		TaskDTO testDTO = new TaskDTO(1L, "Buy Banana", "Shopping", 2, false);
		//rules
		Mockito.when(this.mockRepo.existsById(test_task.getId())).thenReturn(true);
		
		//assertions
		Assertions.assertThat(this.service.delete(testDTO.getId())).isEqualTo(false);

		//verify it has ran once each
		Mockito.verify(this.mockRepo, Mockito.times(1)).deleteById(test_task.getId());
		Mockito.verify(this.mockRepo, Mockito.times(1)).existsById(test_task.getId());

	}
	
}