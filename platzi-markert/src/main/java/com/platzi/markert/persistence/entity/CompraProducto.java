package com.platzi.markert.persistence.entity;

import javax.persistence.*;

@Entity
@Table (name="compras_productos")
public class CompraProducto {

    @EmbeddedId
    private ComprasProductoPk id;

    private Integer cantidad;

    private Integer total;

    private Boolean estado;

    @ManyToOne
    @JoinColumn (name="id_compra",insertable = false,updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name="id_producto",insertable = false,updatable = false)
    private Producto producto;

    public ComprasProductoPk getId() {
        return id;
    }

    public void setId(ComprasProductoPk id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
