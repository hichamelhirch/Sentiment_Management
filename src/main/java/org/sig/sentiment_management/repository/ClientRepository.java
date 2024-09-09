package org.sig.sentiment_management.repository;

import org.sig.sentiment_management.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client findByEmail(String email);
}
