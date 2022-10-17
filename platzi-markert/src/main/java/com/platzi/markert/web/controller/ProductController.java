package com.platzi.markert.web.controller;

import com.platzi.markert.domain.Product;
import com.platzi.markert.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("all")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct (@PathVariable ("productId") int ProductId){
        return productService.getProduct(ProductId)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/category/{productId}")
    public ResponseEntity<List<Product>> getByCategory (@PathVariable ("productId") int CategoryId){
        return productService.getByCategory(CategoryId)
                .map(products -> new ResponseEntity<>(products,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping ("/scare/{productId}")
    public Optional<List<Product>> getScaresProducts (@PathVariable ("productId") int quantity){
        return productService.getScaresProducts(quantity,true);
    }
    @PostMapping("/save")
    public  ResponseEntity<Product> save (@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete (@PathVariable ("id") int ProductId){
        if(productService.delete(ProductId))
        {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
