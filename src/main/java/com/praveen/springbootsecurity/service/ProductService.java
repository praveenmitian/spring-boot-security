package com.praveen.springbootsecurity.service;

import com.praveen.springbootsecurity.model.Product;

public interface ProductService {

    Iterable<Product> getAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
