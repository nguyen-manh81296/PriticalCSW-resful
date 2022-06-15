package com.example.priticalcswresful.model;

import com.example.priticalcswresful.entity.Product;

import java.util.List;

public interface ProductModel {

    List<Product> getProducts();
    boolean addProducts(Product e);
    boolean updateProducts(Product e, int id);
}
