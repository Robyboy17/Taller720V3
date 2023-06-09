package com.eoi.ejemplospringboot.services;

import com.eoi.ejemplospringboot.entities.Empleado;
import com.eoi.ejemplospringboot.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository repository;

    public List<Empleado> findAll() {
        return repository.findAll();
    }

    public Optional<Empleado> findById(Integer id) {
        return repository.findById(id);
    }


}