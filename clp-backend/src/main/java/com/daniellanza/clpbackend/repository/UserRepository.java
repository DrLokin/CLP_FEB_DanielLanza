package com.daniellanza.clpbackend.repository;

import com.daniellanza.clpbackend.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
