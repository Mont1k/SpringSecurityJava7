package com.example.springsecurityjava7.service;

import com.example.springsecurityjava7.entity.Product;
import com.example.springsecurityjava7.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl {
    private final ProductRepository productRepository;
    private List<Product> findAllProducts(){
        return productRepository.findAll();
    }
    public void saveProduct(Product product){
        productRepository.save(product);
    }
    public Product findByIdProduct(Long id){
        return productRepository.findById(id).get();
    }
    public void deleteByIdProduct(Long id){
        productRepository.deleteById(id);
    }
}
