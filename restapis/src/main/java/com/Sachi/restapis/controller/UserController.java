package com.Sachi.restapis.controller;

import com.Sachi.restapis.dto.UserDTO;
import com.Sachi.restapis.dto.UserRequestDTO;
import com.Sachi.restapis.entity.User;
import com.Sachi.restapis.repository.UserRepository;
import com.Sachi.restapis.service.UserService;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping
    public UserDTO createUser(@Valid @RequestBody UserRequestDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id){
        return userService.getUserById((id));
    }

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/page")
    public Page<User> getUsers(
            @RequestParam int page,
            @RequestParam int size
    ){
        return userService.getUserWithPagination(page,size);
    }


}
