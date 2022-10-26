package com.optum.capstone.Specialization.dtos;

import com.optum.capstone.Specialization.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookDto implements Serializable {

    private Long id;
    private String genre;

    public BookDto (Book book){
        if(book.getId() !=null){
            this.id = book.getId();
        }
        if(book.getGenre() !=null){
            this.genre = book.getGenre();
        }

    }
}
