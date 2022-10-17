package com.platzi.markert.persistence.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
}
