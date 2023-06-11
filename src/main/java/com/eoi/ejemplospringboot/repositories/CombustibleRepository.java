package com.eoi.ejemplospringboot.repositories;

import com.eoi.ejemplospringboot.entities.Combustible;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CombustibleRepository extends JpaRepository<Combustible, Long> {
}