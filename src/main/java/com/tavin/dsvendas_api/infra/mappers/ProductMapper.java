package com.tavin.dsvendas_api.infra.mappers;

import com.tavin.dsvendas_api.infra.dto.ProductRequestDto;
import com.tavin.dsvendas_api.infra.dto.ProductResponseDto;
import com.tavin.dsvendas_api.infra.models.ProductModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductModel productModelMapper(ProductRequestDto productRequestDto);

    ProductResponseDto productResponseDto(ProductModel productModel);
}
