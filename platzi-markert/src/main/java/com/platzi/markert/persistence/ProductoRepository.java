package com.platzi.markert.persistence;

import com.platzi.markert.domain.Product;
import com.platzi.markert.domain.repository.ProductRepository;
import com.platzi.markert.persistence.crud.ProductoCrudRepository;
import com.platzi.markert.persistence.entity.Producto;
import com.platzi.markert.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos=(List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoria(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScaresProducts(int quantity, boolean active) {
        Optional <List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, active);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProductById(int productId) {
    //Optional <List<Producto>> productos = productoCrudRepository.findById(productId);
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto= mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto)) ;
    }

    @Override
    public void delete (int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
