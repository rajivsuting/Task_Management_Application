package com.masai.main.service;

import java.util.List;

import com.masai.main.entity.Task;
import com.masai.main.entity.UserEntity;
import com.masai.main.exception.TaskException;
import com.masai.main.exception.UserException;
import com.masai.main.request.CreateTaskRequest;

public interface TaskService {
	
	
	public Task createTask(CreateTaskRequest request) throws UserException;
	
	public List<Task> getAllTasks() throws TaskException;
	
	public Task getTaskById(Long id) throws TaskException;
	
	public List<Task> getTasksByAssignee(UserEntity assignee) throws TaskException;

}
