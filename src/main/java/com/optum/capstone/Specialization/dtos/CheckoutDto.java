package com.optum.capstone.Specialization.dtos;

import com.optum.capstone.Specialization.entities.Checkout;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CheckoutDto implements Serializable {

    private Long id;
    private String book;

public CheckoutDto (Checkout checkout){
    if(checkout.getId() !=null){
        this.id = checkout.getId();
    }
    if(checkout.getBook() !=null){
        this.book = book.getBook();
    }
}

}
