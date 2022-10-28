package com.optum.capstone.Specialization.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="CustomerFavBook")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class CustomerFavBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Boolean favorite;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="customer_id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="book_id")
    private Book book;
}
