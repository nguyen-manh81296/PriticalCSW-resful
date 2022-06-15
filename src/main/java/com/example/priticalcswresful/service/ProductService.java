package com.example.priticalcswresful.service;

import com.example.priticalcswresful.entity.Product;
import com.example.priticalcswresful.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    public Product addProducts(Product product) {
        return productRepository.save(product);
    }
    public List<Product> saveAll(List<Product> product){
        return productRepository.saveAll(product);
    }
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }
}
