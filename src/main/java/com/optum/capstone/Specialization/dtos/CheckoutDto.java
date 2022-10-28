package com.optum.capstone.Specialization.dtos;

import com.optum.capstone.Specialization.entities.Checkout;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CheckoutDto implements Serializable {

    private Long id;
    private String book;
    private Set<CheckoutDto> CheckoutDtoSet = new HashSet<>();

public CheckoutDto (Checkout checkout){
    if(checkout.getId() !=null){
        this.id = checkout.getId();
    }
    if(checkout.getBook() !=null){
        this.book = checkout.getBook();
    }
}

}
