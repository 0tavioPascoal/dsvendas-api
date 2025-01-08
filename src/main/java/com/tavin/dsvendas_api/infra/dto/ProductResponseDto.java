package com.tavin.dsvendas_api.infra.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponseDto(
    UUID id,
    String name,
    String description,
    String sku,
    BigDecimal price
){
}
