package com.JobNest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JobNest.Entity.User;
import com.JobNest.dto.UserDto;
import com.JobNest.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    
    private UserDto convertToDTO(User user) {
        return new UserDto(
            user.getId(),
            user.getFullName(),
            user.getEmail(),
            user.getPassword(),   // include password
            user.getRole()
        );
    }


    private User convertToEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setPassword("dummy"); // or leave it blank if handled elsewhere
        return user;
    }

    @Override
    public UserDto createUser(UserDto userDTO) {
        User user = convertToEntity(userDTO);
        return convertToDTO(userRepository.save(user));
    }

    @Override
    public UserDto getUserById(Long id) {
        return userRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDTO) {
        return userRepository.findById(id).map(user -> {
            user.setFullName(userDTO.getFullName());
            user.setEmail(userDTO.getEmail());
            user.setRole(userDTO.getRole());
            return convertToDTO(userRepository.save(user));
        }).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
