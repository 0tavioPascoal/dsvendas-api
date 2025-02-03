package com.tavin.dsvendas_api.infra.dto.product;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;


public record ProductResponseDto(
        Long id,
        String name,
        String description,
        String sku,
        BigDecimal price,
        LocalDate created,
        LocalDate modified){
}
