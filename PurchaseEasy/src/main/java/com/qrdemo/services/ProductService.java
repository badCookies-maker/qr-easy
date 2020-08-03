package com.qrdemo.services;

import com.qrdemo.entities.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    public List<Product> findAll();
    public Product getProductById(int id);
    public void saveOrUpdate(Product product);
    public void delete(int id);
}