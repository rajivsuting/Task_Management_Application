package com.masai.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.masai.main.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
