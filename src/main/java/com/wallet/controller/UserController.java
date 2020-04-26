package com.wallet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.dto.UserDTO;
import com.wallet.entity.User;
import com.wallet.response.Response;
import com.wallet.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Response<UserDTO>> createUser(@Valid @RequestBody UserDTO userDto, BindingResult result){
		
		Response<UserDTO> response = new Response<UserDTO>();
		User user = userService.save(this.convertDtoToEntity(userDto));
		response.setData(this.convertEntityToDto(user));
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
//isso poderia estar na classe dto	
	private User convertDtoToEntity(UserDTO userDto) {
		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		
		return user;
	}
	
	private UserDTO convertEntityToDto(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setEmail(user.getEmail());
		userDto.setName(user.getName());
		userDto.setPassword(user.getPassword());
		
		return userDto;
	}

}
