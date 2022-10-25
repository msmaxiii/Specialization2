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

@Column
private String biography;

@Column
private String kids;

@Column
private String mystery;

@Column
private String romance;

@Column
private String sci_fi;

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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getKids() {
        return kids;
    }

    public void setKids(String kids) {
        this.kids = kids;
    }

    public String getMystery() {
        return mystery;
    }

    public void setMystery(String mystery) {
        this.mystery = mystery;
    }

    public String getRomance() {
        return romance;
    }

    public void setRomance(String romance) {
        this.romance = romance;
    }

    public String getSci_fi() {
        return sci_fi;
    }

    public void setSci_fi(String sci_fi) {
        this.sci_fi = sci_fi;
    }

    public Book() {
    }

    public Book(Long id, String genre, String biography, String kids, String mystery, String romance, String sci_fi) {
        this.id = id;
        this.genre = genre;
        this.biography = biography;
        this.kids = kids;
        this.mystery = mystery;
        this.romance = romance;
        this.sci_fi = sci_fi;
    }
    //1.creates the association with Hiberate
    //2.prevents infinite recursion when delivering resources up as JSON through Restful API endpoint
    @ManyToOne
    @JsonBackReference
    private Customer customer;
}
