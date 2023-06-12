package com.eoi.ejemplospringboot.repositories;



import com.eoi.ejemplospringboot.entities.Reparacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReparacionRepository extends JpaRepository<Reparacion, Integer> {

}
