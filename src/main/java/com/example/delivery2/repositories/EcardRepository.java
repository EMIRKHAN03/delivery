package com.example.delivery2.repositories;

import com.example.delivery2.models.Client;
import com.example.delivery2.models.Ecard;
import com.example.delivery2.models.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EcardRepository extends JpaRepository<Ecard, Long> {



    Optional<Ecard> findByClient(Client client);

}
