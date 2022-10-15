package com.platzi.markert.domain.repository;

import com.platzi.markert.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScaresProducts (int quantity, boolean active);
    Optional<Product> getProductById (int productId);
    Product save (Product product);
    void delete (int productId);
}
