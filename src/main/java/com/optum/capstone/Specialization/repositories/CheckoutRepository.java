package com.optum.capstone.Specialization.repositories;

import com.optum.capstone.Specialization.entities.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
}
