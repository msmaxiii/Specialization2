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
private String buy;
@Column
private String favorite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public Checkout() {
    }

    public Checkout(Long id, String buy, String favorite) {
        this.id = id;
        this.buy = buy;
        this.favorite = favorite;
    }
    @OneToMany(mappedBy ="customer", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonBackReference
    private Set<Book> bookSet = new HashSet<>();
}
