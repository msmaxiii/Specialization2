package com.optum.capstone.Specialization.repositories;

import com.optum.capstone.Specialization.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
