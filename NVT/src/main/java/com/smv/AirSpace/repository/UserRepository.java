package com.smv.AirSpace.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smv.AirSpace.model.User;
import com.smv.AirSpace.model.UserStatus;
import com.smv.AirSpace.model.UserType;



public interface UserRepository extends JpaRepository<User, Long> {

	
	User findByUsername(String username);
	
	User findByUsernameAndPassword(String username, String password);

	List<User> findByUserTypeAndUserStatus(UserType userType, UserStatus userStatus);
	
	List<User> findAll();

	User findByUsernameAndUserStatus(String username, UserStatus userStatus);

	User save(User user);

	void deleteAll(); 
	
	User findByuuid(String uuid);
	
	
}
