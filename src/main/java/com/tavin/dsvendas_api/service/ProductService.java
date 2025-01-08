package com.tavin.dsvendas_api.service;

import com.tavin.dsvendas_api.infra.models.ProductModel;
import com.tavin.dsvendas_api.repositories.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private  ProductRepository productRepository;

    public void save(ProductModel productModel) {
        productRepository.save(productModel);
    }
}
