package com.tavin.dsvendas_api.service.client;

import com.tavin.dsvendas_api.infra.dto.client.ClientRequestDto;
import com.tavin.dsvendas_api.infra.mappers.client.ClientMapper;
import com.tavin.dsvendas_api.infra.models.ClientModel;
import com.tavin.dsvendas_api.repositories.client.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    public ClientModel saveClient(ClientRequestDto clientRequestDto) {
        ClientModel client = clientMapper.ClientModelMapper(clientRequestDto);
        return clientRepository.save(client);
    }

    public ClientModel findByClientForId(Long id) {
       return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("client not found"));
    }

    public ClientModel updatedClient(Long id, ClientRequestDto clientRequestDto) {
       ClientModel clientAux =  findByClientForId(id);
            clientAux.setAddress(clientRequestDto.address());
            clientAux.setName(clientRequestDto.name());
            clientAux.setEmail(clientRequestDto.email());
            clientAux.setPhone(clientRequestDto.phone());
            clientAux.setBirthday(clientRequestDto.birthday());
            return clientRepository.save(clientAux);
    }

    public Page<ClientModel> findAll(Pageable pageable, String name, String cpf) {
       return clientRepository.findByCpfAndName("%" + name +"%", "%" + cpf + "%", pageable);
    }

    public void deleteByClientForId(Long id) {
        clientRepository.deleteById(id);
    }
}
