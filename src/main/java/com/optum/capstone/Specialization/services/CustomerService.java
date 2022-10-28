package com.optum.capstone.Specialization.services;

import com.optum.capstone.Specialization.dtos.CustomerDto;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerService {
    @Transactional
    List<String> addCustomer(CustomerDto customerDto);

    List<String> customerLogin(CustomerDto customerDto);
}
