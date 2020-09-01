package com.qrdemo.controllers;
import com.qrdemo.entities.Product;
import com.qrdemo.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.Document;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PutMapping
    @CrossOrigin
    public ResponseEntity<Void> add(@RequestBody Product product) {
        productService.saveOrUpdate(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("all")
    @CrossOrigin
    public ResponseEntity<List<Product>> getAll() {
        List<Product> allProducts = productService.findAll();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping("one/{id}")
    @CrossOrigin
    public ResponseEntity<Product> getById(@PathVariable("id") int id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


