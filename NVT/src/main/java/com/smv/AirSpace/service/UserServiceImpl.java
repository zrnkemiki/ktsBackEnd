package com.smv.AirSpace.service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smv.AirSpace.dto.UserDTO;
import com.smv.AirSpace.model.User;
import com.smv.AirSpace.model.UserStatus;
import com.smv.AirSpace.model.UserType;
import com.smv.AirSpace.repository.UserRepository;

import exceptions.UserDoesntExistException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	EMailService emailService;
	
	@Override
	public User findByuuid(String uuid) {
		return userRepository.findByuuid(uuid);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findOne(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User findByID(Long id) {
		Optional<User> rets = userRepository.findById(id);
		if (!rets.isPresent()) {
			throw new UserDoesntExistException();
		}
		return rets.get();
	}

	public User saveUser(UserDTO userDTO) {
		User user = new User(userDTO);
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setUserType(UserType.REGISTERED_USER);
		user.setUserStatus(UserStatus.PENDING);
		emailService.sendMail(user, "Activation link",
				"Please follow the link below to activate \nhttp://localhost:8080/api/user/activate/"
						+ user.getUuid());
		
		userRepository.save(user);
		return user;
	}
	
	public User saveEmpleyee(UserDTO userDTO) {
		User user = new User(userDTO);
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setUserType(UserType.EMPLOYEE);
		user.setUserStatus(UserStatus.PENDING);
		emailService.sendMail(user, "Activation link",
				"Please follow the link below to activate \nhttp://localhost:8080/api/user/activate/"
						+ user.getUuid());
		
		userRepository.save(user);
		return user;
	}
	
	public User saveUser(User user) {
		userRepository.save(user);
		return user;
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User update(UserDTO userDTO, Principal principal) {
		try {
			User user = findByUsername(userDTO.getUsername());
			user.setPhoneNumber(userDTO.getNumber());
			user.setUserType(userDTO.getUserType());
			userRepository.save(user);
			return user;
		} catch (Exception e) {
			throw new UserDoesntExistException();
		}
	}

	public boolean saveAdmin(User user) {
		try {
			userRepository.save(user);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	public boolean existsUsername(String username) {
		User user = userRepository.findByUsername(username);
		return user != null;
	}

	public User getUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new ResourceNotFoundException();
		}
		return user;
	}
	
	public User getLoggedUser(){
		try {
			return getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		} catch (Exception e) {
			if (e instanceof NullPointerException ) {
				return null;
			} 
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean saveAdmin(String username, String email, UserType userType, Long companyId) {
		return false;
	}

	@Override
	public Long findCompanydId(String name, UserType userType) {
		return null;
	}
}
