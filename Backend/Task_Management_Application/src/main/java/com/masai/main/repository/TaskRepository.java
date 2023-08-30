package com.masai.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.masai.main.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	@Query("SELECT t FROM Task t WHERE t.assignee.id = :assigneeId")
    List<Task> findByAssigneeId(@Param("assigneeId") Long assigneeId);

}
