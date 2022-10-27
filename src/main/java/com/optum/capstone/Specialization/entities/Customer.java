package com.optum.capstone.Specialization.entities;

import com.optum.capstone.Specialization.dtos.CustomerDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// 1.tells spring that this class is being mapped and table what objects are being mapped
//  2. created variables
@Entity
@Table(name ="Customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String customer_name;

    @Column
    private String password;

    @Column
    private String email;


 //other half of relationship
 //creates schema for data model
 //cascade defines relationship and lazy gives only reqeseted information
    @OneToMany(mappedBy ="customer", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonBackReference
    private Set<Book> bookSet = new HashSet<>();
}
