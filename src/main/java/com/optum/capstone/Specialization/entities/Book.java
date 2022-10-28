package com.optum.capstone.Specialization.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String genre;


    //1.creates the association with Hiberate
    //2.prevents infinite recursion when delivering resources up as JSON through Restful API endpoint
    @OneToMany (mappedBy = "book")
    @JsonBackReference
    private List<CustomerFavBook> customerFavBookList;

    public List<CustomerFavBook> getCustomerFavBookList() {
        if(customerFavBookList == null){
            customerFavBookList = new ArrayList();
        }
        return customerFavBookList;

    }

}

