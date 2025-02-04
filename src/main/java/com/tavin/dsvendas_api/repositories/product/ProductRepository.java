package com.tavin.dsvendas_api.repositories.product;

import com.tavin.dsvendas_api.infra.models.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {


    @Query("select p from ProductModel p where upper(p.name) like upper(:name) and upper(p.sku) like upper(:sku)")
    Page<ProductModel> findByNameAndSku(@Param("name") String name,
                                        @Param("sku") String sku,
                                        Pageable pageable);
}
