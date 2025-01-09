package com.tavin.dsvendas_api.controllers;

import com.tavin.dsvendas_api.infra.dto.ProductRequestDto;
import com.tavin.dsvendas_api.infra.dto.ProductResponseDto;
import com.tavin.dsvendas_api.infra.mappers.ProductMapper;
import com.tavin.dsvendas_api.infra.models.ProductModel;
import com.tavin.dsvendas_api.repositories.product.ProductRepository;
import com.tavin.dsvendas_api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {


    private final ProductService productService;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto dto) {
        ProductModel p = productMapper.productModelMapper(dto);
        productService.save(p);
        return ResponseEntity.ok().body(productMapper.productResponseDto(p));
    }

    @PutMapping()
    public ResponseEntity<Object> updateProduct(@RequestParam Long id,
                                                @RequestBody ProductRequestDto dto) {
        return productRepository.findById(id)
                .map(ProductModel -> {
                    ProductModel prodAux = productMapper.productModelMapper(dto);
                    ProductModel.setSku(prodAux.getSku());
                    ProductModel.setName(prodAux.getName());
                    ProductModel.setPrice(prodAux.getPrice());
                    ProductModel.setDescription(prodAux.getDescription());
                    productService.UpdateProduct(ProductModel);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public List<ProductResponseDto> getAllProducts() {
        return productService.listProducts().stream()
                .map(productMapper::productResponseDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping()
    public ResponseEntity<Object> deleteProduct(@RequestParam Long id) {
        if(productRepository.existsById(id)) {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } return ResponseEntity.notFound().build();
    }
}
