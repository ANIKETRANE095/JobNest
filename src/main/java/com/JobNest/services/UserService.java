package com.JobNest.services;

import java.util.List;

import com.JobNest.dto.UserDto;

public interface UserService {
	    UserDto createUser(UserDto userDTO);
	    UserDto getUserById(Long id);
	    <UserDTO> List<UserDTO> getAllUsers();
	    UserDto updateUser(Long id, UserDto userDTO);
	    void deleteUser(Long id);
	}


