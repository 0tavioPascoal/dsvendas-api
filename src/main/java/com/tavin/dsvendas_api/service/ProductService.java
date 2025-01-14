package com.tavin.dsvendas_api.service;

import com.tavin.dsvendas_api.infra.mappers.ProductMapper;
import com.tavin.dsvendas_api.infra.models.ProductModel;
import com.tavin.dsvendas_api.repositories.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final  ProductRepository productRepository;
    private final ProductMapper productMapper;

    public void save(ProductModel productModel) {
        productRepository.save(productModel);
    }

    public void UpdateProduct(ProductModel productModel) {
        productRepository.save(productModel);
    }

    public List<ProductModel> listProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<ProductModel> findProductById(Long id) {
        return productRepository.findById(id);
    }
}
