package com.platzi.markert.persistence.mapper;

import com.platzi.markert.domain.Purchase;
import com.platzi.markert.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "comprasProductos", target = "item")
    })
    Purchase toPurchase (Compra compra);

    List<Purchase> toPurchases (List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping(target = "clientes", ignore = true)
    Compra toCompra (Purchase purchase);
}
