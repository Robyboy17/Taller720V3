package com.eoi.ejemplospringboot.repositories;

import com.eoi.ejemplospringboot.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}