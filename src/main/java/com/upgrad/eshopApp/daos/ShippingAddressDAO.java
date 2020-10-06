package com.upgrad.eshopApp.daos;

import com.upgrad.eshopApp.entites.EshopShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("shippingAddressDAO")
public interface ShippingAddressDAO  extends JpaRepository<EshopShippingAddress,Integer> {
}
