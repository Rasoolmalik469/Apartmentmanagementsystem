package org.appartment.repository;

import org.appartment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Rasool Malik Vempalli 
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value="select * from User u where u.email=:email and u.password=:password",nativeQuery = true)
    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);
}
