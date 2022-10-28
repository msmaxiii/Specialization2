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

    @Column(name="Book_Name")
    private String bookName;

    @ManyToOne
    @JoinColumn(name="genre_Id")
    private Genre genre;

    @ManyToMany(mappedBy = "books")
    private List<Customer> customers;


    public List<Customer> getCustomers() {
        if(customers == null){
            customers = new ArrayList<>();
        }
        return customers;
    }

 public void addCustomer( Customer customer){
        this.getCustomers().add(customer);
        customer.getBooks().add(this);
 }



    //1.creates the association with Hiberate
    //2.prevents infinite recursion when delivering resources up as JSON through Restful API endpoint





}
