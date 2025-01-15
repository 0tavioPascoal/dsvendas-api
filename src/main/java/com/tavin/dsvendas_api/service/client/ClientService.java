package com.tavin.dsvendas_api.service.client;

import com.tavin.dsvendas_api.infra.models.ClientModel;
import com.tavin.dsvendas_api.repositories.client.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientModel save(ClientModel clientModel) {
        return clientRepository.save(clientModel);
    }
}
