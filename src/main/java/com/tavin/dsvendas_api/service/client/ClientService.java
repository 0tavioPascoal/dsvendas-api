package com.tavin.dsvendas_api.service.client;

import com.tavin.dsvendas_api.infra.models.ClientModel;
import com.tavin.dsvendas_api.repositories.client.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientModel saveClient(ClientModel clientModel) {
        return clientRepository.save(clientModel);
    }

    public List<ClientModel> findAllClients() {
        return clientRepository.findAll();
    }

    public Optional<ClientModel> findByClientForId(UUID id) {
        return clientRepository.findById(id);
    }

    public ClientModel updatedClient(ClientModel clientModel) {
        return clientRepository.save(clientModel);
    }

    public void deleteByClientForId(UUID id) {
        clientRepository.deleteById(id);
    }
}
