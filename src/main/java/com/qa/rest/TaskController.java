package com.qa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.TaskDomain;
import com.qa.persistence.dto.TaskDTO;
import com.qa.services.TaskService;



@RestController
@RequestMapping("/task")
public class TaskController {

	private TaskService service;



	@Autowired
	public TaskController(TaskService service) {
		super();
		this.service = service;
	}

	// READ ALL TASKS
	@GetMapping("/readAll")
	public ResponseEntity<List<TaskDTO>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}
	
	

	// READ ID OF task
	@GetMapping("/read/{id}")
	public ResponseEntity<TaskDTO> readtask(@PathVariable("id") Long id) {
		 return ResponseEntity.ok(this.service.readOne(id));
	}

	// POST AN TASK
	@PostMapping("/create")
	public ResponseEntity<TaskDTO> create(@RequestBody TaskDomain task) {
		return new ResponseEntity<TaskDTO>(this.service.create(task), HttpStatus.CREATED);

	}

	// UPDATE - PUT
	@PutMapping("/update/{id}")
	public ResponseEntity<TaskDTO> update(@PathVariable("id") Long id, @RequestBody TaskDomain task) {
		return  new ResponseEntity<TaskDTO>(this.service.update(id, task), HttpStatus.ACCEPTED);
	}
	
	
	// DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
		return this.service.delete(id) ? 
				new ResponseEntity<>(HttpStatus.NO_CONTENT):
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
