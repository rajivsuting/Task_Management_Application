package com.masai.main.controller;

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

import com.masai.main.entity.Task;
import com.masai.main.exception.TaskException;
import com.masai.main.exception.UserException;
import com.masai.main.request.CreateTaskRequest;
import com.masai.main.request.UpdateTaskRequest;
import com.masai.main.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	
	@Autowired
	private TaskService taskService;
	

	@PostMapping("/create")
	public ResponseEntity<Task> createTask(@RequestBody CreateTaskRequest request) throws UserException{
		
		Task createdTask = taskService.createTask(request);
		return new ResponseEntity<Task>(createdTask, HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTaskByID(@PathVariable("id") Long id) throws TaskException{
		
		Task existingTask = taskService.getTaskById(id);
		return new ResponseEntity<Task>(existingTask, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Task>> getAllTask() throws TaskException{
		
		List<Task> allTasks = taskService.getAllTasks();
		return new ResponseEntity<List<Task>>(allTasks, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/get/{email}")
	public ResponseEntity<List<Task>> getTaskAssignedByEmail(@PathVariable("email") String email) throws TaskException, UserException{
		
		List<Task> taskAssigned = taskService.getTasksByAssigneeEmail(email);
		return new ResponseEntity<List<Task>>(taskAssigned, HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTaskById(@PathVariable("id") Long id) throws TaskException{
		
		return new ResponseEntity<String>(taskService.deleteTask(id), HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable("id")Long id, @RequestBody UpdateTaskRequest request) throws TaskException{
		
		Task existingTask = taskService.updateTask(id, request);
		return new ResponseEntity<Task>(existingTask, HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/{taskId}/assign/{userId}")
	public ResponseEntity<String> assignUserToTask(@PathVariable Long taskId, @PathVariable Long userId) throws UserException, TaskException{
		 
		String str = taskService.assignUserToTask(taskId, userId);
		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/complete/{id}")
	public ResponseEntity<Task> markTaskCompleted(@PathVariable("id") Long id) throws TaskException{
		
		Task updatedTask = taskService.markTaskCompleted(id);
		return new ResponseEntity<Task>(updatedTask, HttpStatus.ACCEPTED);
	}

}
