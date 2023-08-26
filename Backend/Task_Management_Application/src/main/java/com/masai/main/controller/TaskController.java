package com.masai.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.main.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/create")
	public Tas
	

}
