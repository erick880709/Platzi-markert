package com.platzi.markert.persistence.crud;

import com.platzi.markert.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository <Producto,Integer>{
}
