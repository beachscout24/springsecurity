package com.bridgwater.repository;

import com.bridgwater.models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Clients, Integer> {

    Optional<Clients> findByUsername(String username);
}
