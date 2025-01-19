package com.tavin.dsvendas_api.controllers;

import com.tavin.dsvendas_api.infra.dto.client.ClientRequestDto;
import com.tavin.dsvendas_api.infra.dto.client.ClientResponseDto;
import com.tavin.dsvendas_api.infra.mappers.client.ClientMapper;
import com.tavin.dsvendas_api.infra.models.ClientModel;
import com.tavin.dsvendas_api.repositories.client.ClientRepository;
import com.tavin.dsvendas_api.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = ("*"))
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @PostMapping()
    public ResponseEntity<ClientResponseDto> addClient(@RequestBody ClientRequestDto clientRequestDto) {
        ClientModel client = clientMapper.ClientModelMapper(clientRequestDto);
        clientService.saveClient(client);
        return ResponseEntity.ok().body(clientMapper.ClientResponseMapper(client));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> getClient(@RequestParam String id) {
        return clientService.findByClientForId(UUID.fromString(id))
                .map(client -> {
                    return ResponseEntity.ok().body(clientMapper.ClientResponseMapper(client));
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public Page<ClientResponseDto> getClients(@RequestParam(value = "name", defaultValue = "", required = false) String name,
                                              @RequestParam(value = "cpf", required = false, defaultValue = "") String cpf,
                                              Pageable pageable) {
        return  clientRepository.findByCpfAndName("%" + name +"%", "%" + cpf + "%", pageable)
                .map(clientMapper::ClientResponseMapper);
    }

    @DeleteMapping()
    public ResponseEntity<Object> deleteClient( @RequestParam String id) {
        return clientService.findByClientForId(UUID.fromString(id))
                .map(client -> {
                    clientService.deleteByClientForId(UUID.fromString(id));
                    return ResponseEntity.ok().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PutMapping()
    public ResponseEntity<Object> updateClient(@RequestParam String id,
                                               @RequestBody ClientRequestDto clientRequestDto) {
        return clientService.findByClientForId(UUID.fromString(id))
                .map(client -> {
                    ClientModel clientAux = clientMapper.ClientModelMapper(clientRequestDto);
                    client.setName(clientAux.getName());
                    client.setEmail(clientAux.getEmail());
                    client.setAddress(clientAux.getAddress());
                    client.setBirthday(clientAux.getBirthday());
                    client.setPhone(clientAux.getPhone());
                    clientService.updatedClient(client);
                    return ResponseEntity.noContent().build();
                }).orElseGet(()->ResponseEntity.notFound().build());
    }
}
