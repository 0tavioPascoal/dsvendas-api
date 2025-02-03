package com.tavin.dsvendas_api.infra.dto.sell.sellItens;

import com.tavin.dsvendas_api.infra.dto.product.ProductResponseDto;

import java.math.BigDecimal;

public record SellItensResponseDto(ProductResponseDto product,
                                   Integer amount,
                                   BigDecimal subtotal) {
}
