package com.tavin.dsvendas_api.repositories.product;

import com.tavin.dsvendas_api.infra.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
