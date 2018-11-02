package com.khmil.dao;

import com.khmil.model.Product;

import java.util.List;

public interface ProductDao {

    void save (Product product);

    Product findByName(String name);

    List<Product> findAll();
}
