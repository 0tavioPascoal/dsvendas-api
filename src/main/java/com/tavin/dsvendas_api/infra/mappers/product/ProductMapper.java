package com.tavin.dsvendas_api.infra.mappers.product;

import com.tavin.dsvendas_api.infra.dto.product.ProductRequestDto;
import com.tavin.dsvendas_api.infra.dto.product.ProductResponseDto;
import com.tavin.dsvendas_api.infra.models.ProductModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductModel productModelMapper(ProductRequestDto productRequestDto);

    ProductResponseDto productResponseDto(ProductModel productModel);
}
