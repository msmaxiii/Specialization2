package com.optum.capstone.Specialization.dtos;

import com.optum.capstone.Specialization.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
//used to convert obj to a byte so that it can be changed back into a copy of the object
public class CustomerDto implements Serializable {
    private Long id;
    private String customerName;
    private String password;
    private String email;
    private Set<CustomerDto> customerDtoSet = new HashSet<>();

    public CustomerDto(Customer customer){
        if (customer.getId() != null){
            this.id = customer.getId();
        }
        if( customer.getCustomerName() != null){
            this.customerName = customer.getCustomerName();
        }
        if( customer.getPassword() !=null){
            this.password = customer.getPassword();
        }
        if (customer.getEmail() !=null){
            this.email= customer.getEmail();
        }
    }

}

