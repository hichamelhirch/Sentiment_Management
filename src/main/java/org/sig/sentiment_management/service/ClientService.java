package org.sig.sentiment_management.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.sig.sentiment_management.dtos.ClientDTO;
import org.sig.sentiment_management.entities.Client;
import org.sig.sentiment_management.mappers.ClientMapper;
import org.sig.sentiment_management.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    public void createClient(Client client) {
        Client clientInDB = this.clientRepository.findByEmail(client.getEmail());
        if (clientInDB == null) {
            this.clientRepository.save(client);
        }
    }

    public Stream<ClientDTO> findAllClients() {
        return this.clientRepository.findAll()
                .stream().map(clientMapper);
    }

    public Client getClientById(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElseThrow(
                () -> new EntityNotFoundException("No client exists with this ID")
        );
    }

    public Client readOrCreate(Client clientToCreate) {
        Client clientInDB = this.clientRepository.findByEmail(clientToCreate.getEmail());
        if (clientInDB == null) {
            clientInDB = this.clientRepository.save(clientToCreate);
        }
        return clientInDB;
    }

    public void updateClient(int id, Client client) {
        Client clientInDB = this.getClientById(id);
        if (clientInDB.getId() == client.getId()) {
            clientInDB.setEmail(client.getEmail());
            clientInDB.setTelephone(client.getTelephone());
            this.clientRepository.save(clientInDB);
        }
    }
}
