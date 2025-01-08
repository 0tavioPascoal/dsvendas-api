package com.tavin.dsvendas_api.controllers;

import com.tavin.dsvendas_api.infra.dto.ProductRequestDto;
import com.tavin.dsvendas_api.infra.dto.ProductResponseDto;
import com.tavin.dsvendas_api.infra.models.ProductModel;
import com.tavin.dsvendas_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductModel> createProduct(@RequestBody ProductRequestDto dto) {
       ProductModel p = new ProductModel();
        p.setDescription(dto.description());
        p.setName(dto.name());
        p.setPrice(dto.price());
        p.setSku(dto.sku());
        productService.save(p);
        return ResponseEntity.ok(p);
    }
}
