package com.masai.main.request;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateTaskRequest {
	
    private String title;
    private String description;
    private LocalDate dueDate;
    private String assigneeEmail;

}
