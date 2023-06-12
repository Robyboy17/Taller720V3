package com.eoi.ejemplospringboot.repositories;

import com.eoi.ejemplospringboot.entities.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Integer> {

}