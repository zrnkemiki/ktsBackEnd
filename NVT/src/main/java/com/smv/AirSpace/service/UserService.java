package com.smv.AirSpace.service;

import com.smv.AirSpace.dto.UserDTO;
import com.smv.AirSpace.model.User;
import com.smv.AirSpace.model.UserType;


public interface UserService {
	public User saveUser(UserDTO userDTO);
	
	public boolean saveAdmin(User user);

	public boolean saveAdmin(String username, String email, UserType userType, Long companyId);
	
	public Long findCompanydId(String name, UserType userType);
	
	public User findByuuid(String uuid); 
	
	public User findByUsername(String username);
	
	public User getLoggedUser();

}
