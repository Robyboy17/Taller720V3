package com.eoi.ejemplospringboot.repositories;

import com.eoi.ejemplospringboot.entities.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {
}
