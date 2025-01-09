package com.tavin.dsvendas_api.controllers;

import com.tavin.dsvendas_api.infra.dto.ProductRequestDto;
import com.tavin.dsvendas_api.infra.dto.ProductResponseDto;
import com.tavin.dsvendas_api.infra.mappers.ProductMapper;
import com.tavin.dsvendas_api.infra.models.ProductModel;
import com.tavin.dsvendas_api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {


    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto dto) {
        ProductModel p = productMapper.productModelMapper(dto);
        productService.save(p);
        return ResponseEntity.ok().body(productMapper.productResponseDto(p));
    }
}
