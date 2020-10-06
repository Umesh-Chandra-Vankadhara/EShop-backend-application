package com.upgrad.eshopApp.services;

import com.upgrad.eshopApp.entites.EshopProduct;
import com.upgrad.eshopApp.exceptions.ProductDetailsNotFoundException;

import java.util.List;

public interface ProductService {
    public EshopProduct acceptProductDetails(EshopProduct eshopProduct);
    public EshopProduct getProductDetails(int id)   throws ProductDetailsNotFoundException;
    public EshopProduct updateProductDetails(int productId, EshopProduct eshopProduct) throws ProductDetailsNotFoundException;
    public boolean deleteProduct(int id)  throws ProductDetailsNotFoundException ;
    public List<EshopProduct> getAllProductDetails();
}
