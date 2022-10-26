package com.optum.capstone.Specialization.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }



    public Book() {
    }

    public Book(Long id, String genre) {
        this.id = id;
        this.genre = genre;
    }
    //1.creates the association with Hiberate
    //2.prevents infinite recursion when delivering resources up as JSON through Restful API endpoint
    @ManyToOne
    @JsonBackReference
    private Customer customer;
}

