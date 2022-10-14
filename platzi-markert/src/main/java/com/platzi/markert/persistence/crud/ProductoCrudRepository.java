package com.platzi.markert.persistence.crud;

import com.platzi.markert.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository <Producto,Integer>{
    List<Producto> findByIdCategoria(int idCategoria);
    @Query(value="SELECT * from where id_categoria=?", nativeQuery = true)
    List<Producto> getByIdCategoria(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado (int cantidadStock , boolean estado);
}
