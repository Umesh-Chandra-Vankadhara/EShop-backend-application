package com.upgrad.eshopApp.daos;

import com.upgrad.eshopApp.entites.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("orderDAO")
public interface OrderDAO  extends JpaRepository<Order,Integer> {
}
