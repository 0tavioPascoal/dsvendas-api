package com.tavin.dsvendas_api.infra.dto.sell;

import com.tavin.dsvendas_api.infra.dto.client.ClientResponseDto;
import com.tavin.dsvendas_api.infra.dto.sell.sellItens.SellItensRequestDto;
import com.tavin.dsvendas_api.infra.models.sells.PaymentEnum;

import java.math.BigDecimal;
import java.util.List;

public record SellResponseDto(Long id,
                              ClientResponseDto client,
                              PaymentEnum payment,
                              List<SellItensRequestDto> itens,
                              BigDecimal total) {
}
