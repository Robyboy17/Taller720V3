package com.eoi.ejemplospringboot.repositories;

import com.eoi.ejemplospringboot.entities.TipoReparacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoReparacionRepository extends JpaRepository<TipoReparacion, Integer> {
}
