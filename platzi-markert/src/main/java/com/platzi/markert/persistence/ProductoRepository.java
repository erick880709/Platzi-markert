package com.platzi.markert.persistence;

import com.platzi.markert.persistence.crud.ProductoCrudRepository;
import com.platzi.markert.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
    public List<Producto> getAllByCategoria(int idCategoria){
        return productoCrudRepository.getByIdCategoria(idCategoria);
    }

    public Optional<List<Producto>> escasos (int cantidadStock, boolean estado){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock, estado);
    }

    public Optional<Producto> getProductoById (int id){
        return productoCrudRepository.findById(id);
    }

    public Producto save (Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete (int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
