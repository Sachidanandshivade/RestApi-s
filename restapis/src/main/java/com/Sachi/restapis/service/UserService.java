package com.Sachi.restapis.service;

import com.Sachi.restapis.dto.UserRequestDTO;
import com.Sachi.restapis.entity.User;
import com.Sachi.restapis.exception.ResourceNotFoundException;
import com.Sachi.restapis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.Sachi.restapis.dto.UserDTO;
import java.util.stream.Collectors;
import java.util.List;
import com.Sachi.restapis.dto.UserRequestDTO;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO convertToDTO(User user){
        return new UserDTO(user.getId(),
                user.getName(),
                user.getEmail());

    }
    public User convertToEntity(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    public UserDTO getUserById(Long id){
        User user =userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User Not found"));
        return convertToDTO(user);
    }

    public List<UserDTO> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Page<User> getUserWithPagination(int page, int size){
        Pageable pageable = PageRequest.of(page,size, Sort.by("name").ascending());
        return userRepository.findAll(pageable);
    }

    public UserDTO saveUser(UserRequestDTO dto) {
        User user = convertToEntity(dto);
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }


}
