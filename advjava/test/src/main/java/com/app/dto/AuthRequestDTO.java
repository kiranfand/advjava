package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter 
@Getter 
@ToString 
public class AuthRequestDTO {
	@NotBlank(message ="Email can't be blank!!!" )
	@Email(message = "Invalid email format!!!!!")
	private String email;
	@NotBlank(message = "Password is required!!!")
	private String password;
}
