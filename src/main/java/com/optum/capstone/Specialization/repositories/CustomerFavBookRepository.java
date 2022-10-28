package com.optum.capstone.Specialization.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerFavBookRepository extends JpaRepository<CustomerFavBookRepository, Long> {
}
