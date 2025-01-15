package com.tavin.dsvendas_api.controllers;

import com.tavin.dsvendas_api.infra.dto.client.ClientRequestDto;
import com.tavin.dsvendas_api.infra.dto.client.ClientResponseDto;
import com.tavin.dsvendas_api.infra.mappers.client.ClientMapper;
import com.tavin.dsvendas_api.infra.models.ClientModel;
import com.tavin.dsvendas_api.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
@CrossOrigin(origins = ("*"))
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper mapper;

    @PostMapping()
    public ResponseEntity<ClientResponseDto> addClient(@RequestBody ClientRequestDto clientRequestDto) {
        ClientModel client = mapper.ClientModelMapper(clientRequestDto);
        clientService.save(client);
        return ResponseEntity.ok().body(mapper.ClientResponseMapper(client));
    }


}
