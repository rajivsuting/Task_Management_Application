package com.masai.main.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
	
	 private String name;
	    
	 private String email;
	    
	 private String password;

}
