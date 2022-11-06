package com.optum.capstone.Specialization.dtos;

import com.optum.capstone.Specialization.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
//used to convert obj to a byte so that it can be changed back into a copy of the object
public class UserDto implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Set<UserDto> userDtoSet = new HashSet<>();

    public UserDto(User user){
        if (user.getId() != null){
            this.id = user.getId();
        }
        if( user.getUsername() != null){
            this.username = user.getUsername();
        }
        if( user.getPassword() !=null){
            this.password = user.getPassword();
        }
        if (user.getEmail() !=null){
            this.email= user.getEmail();
        }
    }

}

