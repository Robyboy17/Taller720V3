package com.eoi.ejemplospringboot.repositories;

import com.eoi.ejemplospringboot.entities.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
    List<Modelo> findByMarcaId(Long marcaId);

}