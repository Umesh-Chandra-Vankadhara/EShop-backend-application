package com.upgrad.eshopApp.services;

import com.upgrad.eshopApp.daos.ProductDAO;
import com.upgrad.eshopApp.entites.EshopProduct;
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
    public EshopProduct acceptProductDetails(EshopProduct eshopProduct) {
        logger.debug("Enter accept product details: SAVE" , eshopProduct);
        return productDAO.save(eshopProduct);
    }

    @Override
    public EshopProduct getProductDetails(int id) throws ProductDetailsNotFoundException {
        EshopProduct eshopProduct = productDAO.findById(id).orElseThrow(
                ()->  new ProductDetailsNotFoundException("product not found for " + id));
        return eshopProduct;
    }

    @Override
    public EshopProduct updateProductDetails(int productId, EshopProduct eshopProduct) throws ProductDetailsNotFoundException {
        EshopProduct savedEshopProduct = getProductDetails(productId);
        savedEshopProduct.setDescription(eshopProduct.getDescription());
        savedEshopProduct.setName(eshopProduct.getName());
        savedEshopProduct.setPrice(eshopProduct.getPrice());
        savedEshopProduct.setManufacturer(eshopProduct.getManufacturer());
        savedEshopProduct.setAvailableItems(eshopProduct.getAvailableItems());
        savedEshopProduct.setCategory(eshopProduct.getCategory());
        savedEshopProduct.setImageUrl(eshopProduct.getImageUrl());
        return productDAO.save(savedEshopProduct);
    }

    @Override
    public boolean deleteProduct(int id) throws ProductDetailsNotFoundException {
        EshopProduct eshopProduct = getProductDetails(id);
        productDAO.delete(eshopProduct);
        return true;
    }

    @Override
    public List<EshopProduct> getAllProductDetails() {
        return productDAO.findAll();
    }
}
