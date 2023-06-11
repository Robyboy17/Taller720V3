package com.eoi.ejemplospringboot.repositories;

import com.eoi.ejemplospringboot.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    Optional<Empleado> findByNombre(String empleadoname);

}