package com.generation.repositories;

import com.generation.models.Mochila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MochilaRepository extends JpaRepository<Mochila, Long> {
}
