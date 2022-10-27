package com.optum.capstone.Specialization.entities;

import com.optum.capstone.Specialization.dtos.BookDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(name ="Books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

@Column(unique = true)
   private String genre;


    //1.creates the association with Hiberate
    //2.prevents infinite recursion when delivering resources up as JSON through Restful API endpoint
    @ManyToOne
    @JsonBackReference
   private Customer customer;
}

