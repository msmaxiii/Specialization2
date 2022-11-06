//defines Restful API endpoints
//creates paths to deliver information to clients
//interacts with ServiceLayers and PasswordEncoder
//handles POST request to register User

package com.optum.capstone.Specialization.controller;

import com.optum.capstone.Specialization.dtos.UserDto;
import com.optum.capstone.Specialization.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
   @Autowired
    private UserService userService;
@Autowired
    private PasswordEncoder  passwordEncoder;

    @PostMapping("/register")
    public List<String>addUser(@RequestBody UserDto userDto){
        String passHash = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(passHash);
        return userService.addUser(userDto);
    }
    @PostMapping("/login")
    public List<String>userLogin(@RequestBody UserDto userDto){
        return userService.userLogin(userDto);
    }

}
