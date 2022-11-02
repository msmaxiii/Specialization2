//holds business logic (brains)
//receives information from the repository layer where it performs any transformations
//passes it to the controller to handle request

package com.optum.capstone.Specialization.services;

import com.optum.capstone.Specialization.dtos.CustomerDto;
import com.optum.capstone.Specialization.entities.Customer;
import com.optum.capstone.Specialization.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public List<String> addCustomer(CustomerDto customerDto) {
        List<String> response = new ArrayList<>();
        Customer customer = new Customer(customerDto);
        customerRepository.saveAndFlush(customer);
        response.add("http://localhost:8080/home.html");
        return response;
    }
         @Override
         public List<String> customerLogin(CustomerDto customerDto) {
            List<String> response = new ArrayList<>();
          Optional<Customer> customerOptional =customerRepository.findByCustomerName(customerDto.getCustomerName());
        if (customerOptional.isPresent()) {
            if (passwordEncoder.matches(customerDto.getPassword(), customerOptional.get().getPassword())) {
                response.add("http://localhost:8080/home.html");
                response.add(String.valueOf(customerOptional.get().getId()));
            } else {
                response.add("Customer_name or password incorrect");
            }
        } else {
            response.add("Customer_name or password incorrect");
        }
        return response;

        }
    }

