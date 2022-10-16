package com.platzi.markert.domain.service;

import com.platzi.markert.domain.Product;
import com.platzi.markert.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }
    public Optional<Product> getProduct (int ProductId){
        return productRepository.getProductById(ProductId);
    }
    public Optional<List<Product>> getByCategory (int CategoryId){
        return productRepository.getByCategory(CategoryId);
    }
    public Optional<List<Product>> getScaresProducts (int quantity, boolean active){
        return productRepository.getScaresProducts(quantity,active);
    }
    public  Product save (Product product){
        return  productRepository.save(product);
    }
    public Boolean delete (int ProductId){
        return getProduct(ProductId).map(product -> {
            productRepository.delete(ProductId);
            return true;
        }).orElse(false);
    }
}
