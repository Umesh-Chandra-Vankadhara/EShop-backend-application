package com.upgrad.eshopApp.services;

import com.upgrad.eshopApp.entites.Product;
import com.upgrad.eshopApp.exceptions.ProductDetailsNotFoundException;

import java.util.List;

public interface ProductService {
    public Product acceptProductDetails(Product product);
    public Product getProductDetails(int id)   throws ProductDetailsNotFoundException;
    public Product updateProductDetails(int productId, Product product) throws ProductDetailsNotFoundException;
    public boolean deleteProduct(int id)  throws ProductDetailsNotFoundException ;
    public List<Product> getAllProductDetails();
}
