//interacts  with database using SpringJpa
//this layers uses Interfaces with carats the keep track of the type field
//repo annotation give Spring boot clues to keep track of this for dependency injection

package com.optum.capstone.Specialization.repositories;

import com.optum.capstone.Specialization.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User>findByUsername(String username);


}
