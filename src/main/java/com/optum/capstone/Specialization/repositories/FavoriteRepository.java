package com.optum.capstone.Specialization.repositories;

import com.optum.capstone.Specialization.entities.Customer;
import com.optum.capstone.Specialization.entities.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite>findAllByCustomerEquals(Customer customer);
}
