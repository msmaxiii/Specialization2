//defines Restful API endpoints
//creates paths to deliver information to clients
//interacts with ServiceLayers and PasswordEncoder
//handles POST request to register User

package com.optum.capstone.Specialization.controller;

import com.optum.capstone.Specialization.dtos.CustomerDto;
import com.optum.capstone.Specialization.entities.Customer;
import com.optum.capstone.Specialization.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder  passwordEncoder;

    @PostMapping("/register")
    public List<String>addCustomer(@RequestBody CustomerDto customerDto){
        String passHash = passwordEncoder.encode(customerDto.getPassword());
        customerDto.setPassword(passHash);
        return customerService.addCustomer(customerDto);
    }
    @PostMapping("/login")
    public List<String>customerLogin(@RequestBody CustomerDto customerDto){
        return customerService.customerLogin(customerDto);
    }

}
