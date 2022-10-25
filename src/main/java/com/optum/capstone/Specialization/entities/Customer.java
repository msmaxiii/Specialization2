package com.optum.capstone.Specialization.entities;


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

//create getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
// no Args constructor and All Argument
    public Customer() {
    }

    public Customer(Long id, String customer_name, String password, String email) {
        this.id = id;
        this.customer_name = customer_name;
        this.password = password;
        this.email = email;
    }
 //other half of relationship
 //creates schema for data model
 //cascade defines relationship and lazy gives only reqeseted information
    @OneToMany(mappedBy ="customer", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonBackReference
    private Set<Book> bookSet = new HashSet<>();
}
