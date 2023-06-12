package com.eoi.ejemplospringboot.repositories;

import com.eoi.ejemplospringboot.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}