package com.eoi.ejemplospringboot.services;

import com.eoi.ejemplospringboot.entities.Empresa;
import com.eoi.ejemplospringboot.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    private final EmpresaRepository repository;

    @Autowired
    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public List<Empresa> findAll() {
        return repository.findAll();
    }

    public Optional<Empresa> findById(Integer id) {
        return repository.findById(id);
    }


}
