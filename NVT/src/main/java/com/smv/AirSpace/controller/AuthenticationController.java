package com.smv.AirSpace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smv.AirSpace.dto.LoginDTO;
import com.smv.AirSpace.dto.UserDTO;
import com.smv.AirSpace.security.TokenUtils;
import com.smv.AirSpace.service.UserServiceImpl;

@RestController("login")
public class AuthenticationController {
	
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	TokenUtils tokenUtils;
	
	@Autowired
	UserServiceImpl userService;
		
	
	@PostMapping()
	public ResponseEntity<?> login(@RequestBody()LoginDTO loginDTO){
		
		try {
        	// Perform the authentication
        	UsernamePasswordAuthenticationToken token = 
        			new UsernamePasswordAuthenticationToken(
					loginDTO.getUsername(), loginDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(token);            
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Reload user details so we can generate token
            UserDetails details = userDetailsService.
            		loadUserByUsername(loginDTO.getUsername());
            
            UserDTO user = new UserDTO(userService.getLoggedUser());
            
            user.setJWTToken(tokenUtils.generateToken(details));
            return new ResponseEntity<UserDTO>(
            		user, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
	}
	
	
	


}
