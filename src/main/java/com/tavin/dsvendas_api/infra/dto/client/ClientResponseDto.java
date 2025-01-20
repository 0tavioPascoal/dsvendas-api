package com.tavin.dsvendas_api.infra.dto.client;

import java.time.LocalDate;
import java.util.UUID;

public record ClientResponseDto(Long id,
                                String name,
                                String email,
                                String phone,
                                String cpf,
                                String address,
                                LocalDate birthday,
                                LocalDate created,
                                LocalDate modified) {
}
