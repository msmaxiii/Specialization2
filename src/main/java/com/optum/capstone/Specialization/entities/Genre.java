package com.optum.capstone.Specialization.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Genre")
@Data
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Genre_Name")
    private String genreName;

    @OneToMany(mappedBy = "genre")
    private List<Book> books;

    public List<Book> getBooks() {
        if(books == null){
            books = new ArrayList<>();
        }
        return books;
    }

    public void addBook( Book book){
        this.getBooks().add(book);
        book.setGenre(this);

}
}
