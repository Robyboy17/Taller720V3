package com.eoi.ejemplospringboot.repositories;



import com.eoi.ejemplospringboot.entities.Reparacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReparacionRepository extends JpaRepository<Reparacion, Long> {
}
