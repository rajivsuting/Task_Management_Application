package com.masai.main.service;

import java.util.List;

import com.masai.main.entity.Task;
import com.masai.main.entity.UserEntity;
import com.masai.main.exception.TaskException;
import com.masai.main.exception.UserException;
import com.masai.main.request.CreateTaskRequest;
import com.masai.main.request.UpdateTaskRequest;

public interface TaskService {
	
	
	public Task createTask(CreateTaskRequest request) throws UserException;
	
	public List<Task> getAllTasks() throws TaskException;
	
	public Task getTaskById(Long id) throws TaskException;
	
	public List<Task> getTasksByAssigneeEmail(String email) throws TaskException, UserException;
	
	public String deleteTask(Long id)throws TaskException;
	
	public Task updateTask(Long id, UpdateTaskRequest request) throws TaskException;
	
	public String assignUserToTask(Long taskId, Long userId) throws UserException, TaskException;
	
	public Task markTaskCompleted(Long id) throws TaskException;

}
