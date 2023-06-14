package com.eoi.ejemplospringboot.repositories;

import com.eoi.ejemplospringboot.entities.Marca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {
}