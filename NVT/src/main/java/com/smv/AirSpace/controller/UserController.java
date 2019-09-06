package com.smv.AirSpace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smv.AirSpace.dto.UserDTO;
import com.smv.AirSpace.model.User;
import com.smv.AirSpace.model.UserStatus;
import com.smv.AirSpace.service.UserServiceImpl;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	

	
	// Create new user.
	@PostMapping( consumes = "application/json")
	public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
		User user = userService.saveUser(userDTO);
		
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}


	@GetMapping(value = "/activate/{uuid}")
	public String activateUser(@PathVariable("uuid") String uuid) {
		User user = userService.findByuuid(uuid);
		if (user != null) {
			if (user.getUserStatus() == UserStatus.PENDING) {
				user.setUserStatus(UserStatus.ACTIVATED);
				userService.saveUser(user);
				return String.format("<p>Succesfully activated! <p> <p>%s welcome to site!<p>", user.getUsername());
			} else {
				return "User allready activated!";
			}
		}
		return "Bad activation link!";
	}

}
