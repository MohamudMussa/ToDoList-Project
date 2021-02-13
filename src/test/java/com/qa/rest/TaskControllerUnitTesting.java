package com.qa.rest;




import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.persistence.domain.TaskDomain;
import com.qa.persistence.dto.TaskDTO;
import com.qa.services.TaskService;

@SpringBootTest
public class TaskControllerUnitTesting {

	@MockBean
	private TaskService service;

	@Autowired
	TaskController controller;

	@MockBean
	private ModelMapper mapper;

	private TaskDTO mapToDTO(TaskDomain model) {
		return this.mapper.map(model, TaskDTO.class);
	}

	@Test
	public void readAll() {
	

}
}