package com.Sachi.restapis.service;

import com.Sachi.restapis.entity.User;
import com.Sachi.restapis.exception.ResourceNotFoundException;
import com.Sachi.restapis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not found with id" +id));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Page<User> getUserWithPagination(int page, int size){
        Pageable pageable = PageRequest.of(page,size, Sort.by("name").ascending());
        return userRepository.findAll(pageable);
    }
}
