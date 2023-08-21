package com.masai.main.request;

import com.masai.main.entity.UserEntity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private UserEntity assignee;

}
