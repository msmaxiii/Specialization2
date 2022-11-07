package com.optum.capstone.Specialization.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.optum.capstone.Specialization.dtos.FavoriteDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Entity
@Table(name="Favorites")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String favorite;

    @Column
    private String body;
    //many to one creates association within Hibernate
// Jsonback ref prevents infinite recursion when you deliver the resource up as Json using Restful APi endpoints
  @ManyToOne
   @JsonBackReference
    private User user;

    public Favorite(FavoriteDto favoriteDto){
        if(favoriteDto.getFavorite() !=null){
            this.favorite = favoriteDto.getFavorite();
        }
    }

 }



    //1.creates the association with Hiberate
    //2.prevents infinite recursion when delivering resources up as JSON through Restful API endpoint






