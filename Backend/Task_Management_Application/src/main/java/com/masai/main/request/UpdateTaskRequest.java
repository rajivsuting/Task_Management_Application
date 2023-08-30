package com.masai.main.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskRequest {
	
    private String title;
    private String description;
    private LocalDate dueDate;

}
