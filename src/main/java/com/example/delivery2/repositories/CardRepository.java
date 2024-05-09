package com.example.delivery2.repositories;

import com.example.delivery2.models.Ecard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Ecard, Long> {
}
