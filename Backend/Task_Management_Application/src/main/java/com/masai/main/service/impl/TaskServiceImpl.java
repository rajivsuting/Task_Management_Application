package com.masai.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.main.entity.Task;
import com.masai.main.entity.UserEntity;
import com.masai.main.exception.TaskException;
import com.masai.main.exception.UserException;
import com.masai.main.repository.TaskRepository;
import com.masai.main.repository.UserRepository;
import com.masai.main.request.CreateTaskRequest;
import com.masai.main.service.TaskService;


@Service
public class TaskServiceImpl implements TaskService {
	
	
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Task createTask(CreateTaskRequest request) throws UserException {
		
		Task task = new Task();
		task.setTitle(request.getTitle());
		task.setDescription(request.getDescription());
		task.setCompleted(false);
		task.setDueDate(request.getDueDate());
		
		UserEntity assignee = null;
		
		if(request.getAssigneeEmail() != null && !request.getAssigneeEmail().isEmpty()) {
			assignee = userRepository.findByEmail(request.getAssigneeEmail()).orElseThrow(() -> 
			new UserException("Cannot assign this task to a user since no user can be found with this email"+ request.getAssigneeEmail()));
		}
		task.setAssignee(assignee);
		
		return taskRepository.save(task);
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
