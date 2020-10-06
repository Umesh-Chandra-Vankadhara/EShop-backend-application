package com.upgrad.eshopApp.daos;

import com.upgrad.eshopApp.entites.EshopProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productDAO")
public interface ProductDAO  extends JpaRepository<EshopProduct,Integer> {
}
