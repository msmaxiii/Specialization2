package com.optum.capstone.Specialization.entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Checkouts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Checkout {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@Column(unique = true)
private String checkout;

@Column
private String book;


    @OneToMany(mappedBy ="customer", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonBackReference
    private Set<Book> bookSet = new HashSet<>();


}
