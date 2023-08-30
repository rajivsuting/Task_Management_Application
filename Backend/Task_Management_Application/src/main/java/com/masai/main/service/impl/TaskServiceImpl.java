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
import com.masai.main.request.UpdateTaskRequest;
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
		if(tasks.isEmpty()) throw new TaskException("Tasks not found in the database.");
		
		return tasks;
	}

	@Override
	public Task getTaskById(Long id) throws TaskException {
		
		Optional<Task> opt = taskRepository.findById(id);
		
		if(opt.isEmpty()) throw new TaskException("No task found with id: "+id);
		
		return opt.get();
	}

	@Override
	public List<Task> getTasksByAssigneeEmail(String email) throws TaskException, UserException {
		
		UserEntity assignee = userRepository.findByEmail(email).orElseThrow(() -> new UserException("No user found with email "+email));
		
		List<Task> allTasks = assignee.getAssignedTasks();
		
		if(allTasks.isEmpty()) throw new TaskException("No task found for this user");
		
		return allTasks;
	}

	@Override
	public String deleteTask(Long id) throws TaskException {
		
		Task existingTask = taskRepository.findById(id).orElseThrow(() ->
			new TaskException("Task not found with id "+id)
		);
		
		taskRepository.delete(existingTask);
		return existingTask.getTitle() + " is deleted successfully.";
	}

	@Override
	public Task updateTask(Long id, UpdateTaskRequest request) throws TaskException {
		
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskException("Task not found with ID: " + id));


        existingTask.setTitle(request.getTitle());
        existingTask.setDescription(request.getDescription());
        existingTask.setDueDate(request.getDueDate());
        
        return taskRepository.save(existingTask);
	}

	@Override
	public String assignUserToTask(Long taskId, Long userId) throws UserException, TaskException {
		
	        Task task = taskRepository.findById(taskId)
	                .orElseThrow(() -> new TaskException("Task not found with ID: " + taskId));

	        UserEntity user = userRepository.findById(userId)
	                .orElseThrow(() -> new UserException("User not found with ID: " + userId));

	        task.setAssignee(user);
	        taskRepository.save(task);

	        return "Task assigned to "+user.getName()+ " successfully.";
	    
	}

	@Override
	public Task markTaskCompleted(Long id) throws TaskException {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskException("Task not found with ID: " + id));

        task.setCompleted(true);
        return taskRepository.save(task);
	}
	
	

}
