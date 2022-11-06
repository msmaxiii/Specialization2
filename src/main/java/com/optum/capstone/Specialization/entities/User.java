package com.optum.capstone.Specialization.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.optum.capstone.Specialization.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


// 1.tells spring that this class is being mapped and table what objects are being mapped
//  2. created variables
//used to create the schema

//other half of relationship
//creates schema for data model
//cascade defines relationship and lazy gives only reqeseted information
@Entity
@Table (name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private members variable only accessible within the class the reside
    // to access you must use getters and setters
    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    public Long getId() {
        return id;
    }
    //used to create the schema
   @OneToMany(mappedBy ="user",fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
   @JsonManagedReference
    private Set<Favorite>favoriteSet = new HashSet<>();

//constructors help create the objects

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // no argument contructor
    public User() {
    }
    //all argument constructor
    public User(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // logic for database
    public User(UserDto userDto){
        if(userDto.getUsername() !=null){
            this.username = userDto.getUsername();
        }
        if(userDto.getPassword() !=null){
            this.password = userDto.getPassword();
        }
        if(userDto.getEmail()!= null){
            this.email = userDto.getEmail();
        }
    }
}





