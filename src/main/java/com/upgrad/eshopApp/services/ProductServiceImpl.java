package com.upgrad.eshopApp.services;

import com.upgrad.eshopApp.daos.ProductDAO;
import com.upgrad.eshopApp.entites.Product;
import com.upgrad.eshopApp.exceptions.ProductDetailsNotFoundException;
import com.upgrad.eshopApp.utils.DTOEntityConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    @Qualifier("productDAO")
    private ProductDAO productDAO ;
    @Autowired
    DTOEntityConverter dtoEntityConverter;

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public Product acceptProductDetails(Product product) {
        logger.debug("Enter accept product details: SAVE" ,product);
        return productDAO.save(product);
    }

    @Override
    public Product getProductDetails(int id) throws ProductDetailsNotFoundException {
        Product product = productDAO.findById(id).orElseThrow(
                ()->  new ProductDetailsNotFoundException("product not found for " + id));
        return product;
    }

    @Override
    public Product updateProductDetails(int productId, Product product) throws ProductDetailsNotFoundException {
        Product savedProduct = getProductDetails(productId);
        savedProduct.setDescription(product.getDescription());
        savedProduct.setName(product.getName());
        savedProduct.setPrice(product.getPrice());
        savedProduct.setManufacturer(product.getManufacturer());
        savedProduct.setAvailableItem(product.getAvailableItem());
        savedProduct.setCategory(product.getCategory());
        savedProduct.setImageUrl(product.getImageUrl());
        return productDAO.save(savedProduct);
    }

    @Override
    public boolean deleteProduct(int id) throws ProductDetailsNotFoundException {
        Product product = getProductDetails(id);
        productDAO.delete(product);
        return true;
    }

    @Override
    public List<Product> getAllProductDetails() {
        return productDAO.findAll();
    }
}
