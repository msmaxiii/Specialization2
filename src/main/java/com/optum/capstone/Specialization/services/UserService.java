package com.optum.capstone.Specialization.services;

import com.optum.capstone.Specialization.dtos.UserDto;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);
}
//handles registering the user
//verify user credentials and logging in
// use transactional when you save to database to ensure transactions that get opened with datasource gets resolved