package com.upgrad.eshopApp.daos;


import com.upgrad.eshopApp.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userDAO")
public interface UserDAO  extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
