package com.tavin.dsvendas_api.infra.dto.client;

import java.time.LocalDate;

public record ClientRequestDto(String name,
                               String email,
                               String phone,
                               String cpf,
                               String address,
                               LocalDate birthday) {
}
