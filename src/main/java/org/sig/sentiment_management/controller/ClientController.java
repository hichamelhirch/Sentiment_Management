package org.sig.sentiment_management.controller;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import lombok.RequiredArgsConstructor;
import org.sig.sentiment_management.dtos.ClientDTO;
import org.sig.sentiment_management.entities.Client;
import org.sig.sentiment_management.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "client")
public class ClientController {
    private final ClientService clientService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Client client){
        clientService.createClient(client);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Stream<ClientDTO> findAll() {
        return clientService.findAllClients();
    }

    @GetMapping(path="{id}", produces = APPLICATION_JSON_VALUE)
    public Client getById(@PathVariable int id) {
        return clientService.getClientById(id);
    }

    @ResponseStatus(NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void update(@PathVariable int id, @RequestBody Client client) {
        clientService.updateClient(id,client);
    }

}
