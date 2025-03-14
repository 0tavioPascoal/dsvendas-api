package com.tavin.dsvendas_api.infra.dto.product;

import java.math.BigDecimal;

public record ProductRequestDto(

        String name,
        String description,
        String sku,
        BigDecimal price
) {
}
