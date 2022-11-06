package com.optum.capstone.Specialization.dtos;

import com.optum.capstone.Specialization.entities.Favorite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteDto implements Serializable {
    private Long id;
    private String favorite;

    private UserDto userDto;


    public FavoriteDto(Favorite favorite){
        if(favorite.getId() !=null){
            this.id = favorite.getId();
        }
        if(favorite.getFavorite() !=null){
            this.favorite = favorite.getFavorite();
        }

    }
}
