package com.tavin.dsvendas_api.infra.mappers.client;

import com.tavin.dsvendas_api.infra.dto.client.ClientRequestDto;
import com.tavin.dsvendas_api.infra.dto.client.ClientResponseDto;
import com.tavin.dsvendas_api.infra.models.ClientModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientModel ClientModelMapper(ClientRequestDto requestDto);

    ClientResponseDto ClientResponseMapper(ClientModel clientModel);
}
