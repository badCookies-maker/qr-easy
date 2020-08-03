package com.qrdemo.services;


import com.qrdemo.entities.Product;
import com.qrdemo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product getProductById(int id){
        return productRepository.findById(id).get();
    }
    @Override
    public void saveOrUpdate(Product product){
        productRepository.save(product);
    }
    @Override
    public void delete(int id){
        productRepository.deleteById(id);
    }


}