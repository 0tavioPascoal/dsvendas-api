package com.tavin.dsvendas_api.service;

import com.tavin.dsvendas_api.infra.dto.ProductRequestDto;
import com.tavin.dsvendas_api.infra.dto.ProductResponseDto;
import com.tavin.dsvendas_api.infra.mappers.ProductMapper;
import com.tavin.dsvendas_api.infra.models.ProductModel;
import com.tavin.dsvendas_api.repositories.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final  ProductRepository productRepository;
    private final ProductMapper productMapper;

    public void save(ProductModel productModel) {
        productRepository.save(productModel);
    }

}
