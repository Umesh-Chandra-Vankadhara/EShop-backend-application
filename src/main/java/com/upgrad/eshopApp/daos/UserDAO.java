package com.upgrad.eshopApp.daos;


import com.upgrad.eshopApp.entites.EshopUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userDAO")
public interface UserDAO  extends JpaRepository<EshopUser,Integer> {
    Optional<EshopUser> findByUsername(String username);
}
