package com.optum.capstone.Specialization.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.optum.capstone.Specialization.dtos.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


// 1.tells spring that this class is being mapped and table what objects are being mapped
//  2. created variables
//used to create the schema

//other half of relationship
//creates schema for data model
//cascade defines relationship and lazy gives only reqeseted information
@Entity
@Table(name="Customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String customerName;

    @Column
    private String password;
    @Column
    private String email;


    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade={CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Favorite> favoriteSet= new HashSet<>();

    // logic for database
    public Customer(CustomerDto customerDto) {
        if (customerDto.getCustomerName() != null) {
            this.customerName = customerDto.getCustomerName();
        }
        if (customerDto.getPassword() != null) {
            this.password = customerDto.getPassword();
        }
        if (customerDto.getEmail() != null) {
            this.email = customerDto.getEmail();
        }
    }
}




