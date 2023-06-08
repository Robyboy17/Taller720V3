package com.eoi.ejemplospringboot.repositories;

import com.eoi.ejemplospringboot.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, String> {

    Rol findByName(String name);
}