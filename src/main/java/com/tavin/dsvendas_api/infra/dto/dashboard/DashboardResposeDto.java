package com.tavin.dsvendas_api.infra.dto.dashboard;

public record DashboardResposeDto(
        long products,
        long clients,
        long sells
) {
}
