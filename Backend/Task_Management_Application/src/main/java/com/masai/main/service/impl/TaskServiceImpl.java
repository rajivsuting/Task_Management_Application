package com.masai.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.main.entity.Task;
import com.masai.main.entity.UserEntity;
import com.masai.main.exception.TaskException;
import com.masai.main.repository.TaskRepository;
import com.masai.main.request.CreateTaskRequest;
import com.masai.main.service.TaskService;


@Service
public class TaskServiceImpl implements TaskService {
	
	
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task createTask(CreateTaskRequest request) {
		
		return null;
	}

	@Override
	public List<Task> getAllTasks() throws TaskException {
		
		List<Task> tasks = taskRepository.findAll();
		if(tasks.isEmpty()) throw new TaskException("Task not found in the database.");
		
		return tasks;
	}

	@Override
	public Task getTaskById(Long id) throws TaskException {
		
		Optional<Task> opt = taskRepository.findById(id);
		
		if(opt.isEmpty()) throw new TaskException("No task found with id: "+id);
		
		return opt.get();
	}

	@Override
	public List<Task> getTasksByAssignee(UserEntity assignee) throws TaskException {
		
		return null;
	}

}
