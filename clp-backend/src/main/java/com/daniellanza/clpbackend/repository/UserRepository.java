package com.daniellanza.clpbackend.repository;

import com.daniellanza.clpbackend.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmailAndPassword(String email,String password);

    User findByEmail(String email);

    User findByUsername(String username);


}
