package com.tavin.dsvendas_api.controllers;

import com.tavin.dsvendas_api.infra.dto.client.ClientRequestDto;
import com.tavin.dsvendas_api.infra.dto.client.ClientResponseDto;
import com.tavin.dsvendas_api.infra.mappers.client.ClientMapper;
import com.tavin.dsvendas_api.infra.models.ClientModel;
import com.tavin.dsvendas_api.repositories.client.ClientRepository;
import com.tavin.dsvendas_api.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = ("*"))
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping()
    public ResponseEntity<ClientModel> addClient(@RequestBody ClientRequestDto clientRequestDto) {
       return new ResponseEntity<>(clientService.saveClient(clientRequestDto), HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<ClientModel> getClient(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.findByClientForId(id), HttpStatus.FOUND);
    }

    @GetMapping()
    public ResponseEntity<Page<ClientModel>> getClients(@RequestParam(value = "name", defaultValue = "", required = false) String name,
                                              @RequestParam(value = "cpf", required = false, defaultValue = "") String cpf,
                                              Pageable pageable) {
        return new ResponseEntity<>(clientService.findAll(pageable, name, cpf), HttpStatus.FOUND);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteClient( @RequestParam Long id) {
            clientService.deleteByClientForId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<ClientModel> updateClient(@RequestParam Long id,
                                               @RequestBody ClientRequestDto clientRequestDto) {
            return new ResponseEntity<>(clientService.updatedClient(id, clientRequestDto) ,HttpStatus.OK);
    }
}
