package com.platzi.markert.persistence;

import com.platzi.markert.persistence.crud.ProductoCrudRepository;
import com.platzi.markert.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
