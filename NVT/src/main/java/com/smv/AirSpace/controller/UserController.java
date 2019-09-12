package com.smv.AirSpace.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDTO>> getAll() {
		List<User> users = userService.findAll();
		List<UserDTO> usersDTO = new ArrayList<>();
		for (User u : users) {
			usersDTO.add(new UserDTO(u));
		}
		
		try {
			return new ResponseEntity<>(usersDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id) {
		User user = userService.findByID(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		UserDTO userDTO = new UserDTO(user);
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}

	// Create new user.
	@PostMapping(consumes = "application/json")
	public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
		User user = userService.saveUser(userDTO);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO, Principal principal) {
		return new ResponseEntity<>(userService.update(userDTO, principal), HttpStatus.OK);
	}

	// Create new employee.
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PostMapping(value = "/addEmployee", consumes = "application/json")
	public ResponseEntity<User> addEmployee(@RequestBody UserDTO userDTO) {
		User user = userService.saveEmpleyee(userDTO);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
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
