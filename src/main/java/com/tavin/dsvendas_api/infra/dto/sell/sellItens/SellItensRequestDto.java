package com.tavin.dsvendas_api.infra.dto.sell.sellItens;

import com.tavin.dsvendas_api.infra.dto.product.ProductResponseDto;

public record SellItensRequestDto(
        ProductResponseDto product,
        Integer amount
) {
}
