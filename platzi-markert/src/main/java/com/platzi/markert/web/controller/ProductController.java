package com.platzi.markert.web.controller;

import com.platzi.markert.domain.Product;
import com.platzi.markert.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("all")
    public List<Product> getAll() {
        return productService.getAll();
    }
    @GetMapping("/{productId}")
    public Optional<Product> getProduct (@PathVariable ("productId") int ProductId){
        return productService.getProduct(ProductId);
    }
    public Optional<List<Product>> getByCategory (int CategoryId){
        return productService.getByCategory(CategoryId);
    }
    public Optional<List<Product>> getScaresProducts (int quantity, boolean active){
        return productService.getScaresProducts(quantity,active);
    }
    public  Product save (Product product){
        return productService.save(product);
    }
    public Boolean delete (int ProductId){
        return productService.delete(ProductId);
    }
}
