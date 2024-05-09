package com.example.delivery2.repositories;

import com.example.delivery2.Enums.Roles;
import com.example.delivery2.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByUsername(String username);
    List<Client> findByRoles(Roles roles);
    Double countByRoles(Roles roles);

}
