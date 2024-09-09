package org.sig.sentiment_management.mappers;

import org.sig.sentiment_management.dtos.ClientDTO;
import org.sig.sentiment_management.entities.Client;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ClientMapper implements Function<Client, ClientDTO> {

    @Override
    public ClientDTO apply(Client client) {
        return new ClientDTO(client.getId(), client.getEmail(), client.getTelephone());
    }
}
