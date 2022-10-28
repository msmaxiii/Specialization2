package com.optum.capstone.Specialization.dtos;

import com.optum.capstone.Specialization.entities.CustomerFavBook;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CustomerFavBookDto implements Serializable {

    private Long id;
    private String bookId;
    private String customerId;
    private Set<CustomerFavBookDto> customerFavBookDtoSet = new HashSet<>();

    public CustomerFavBookDto(CustomerFavBook customerFavBook){
            if(customerFavBook.getId() !=null){
                this.id = customerFavBook.getId();
            }
            if(customerFavBook.getId() !=null){
            this.bookId = String.valueOf(customerFavBook.getId());
             }
             if(customerFavBook.getId() !=null){
            this.customerId = String.valueOf(customerFavBook.getId());

}
    }
       }
