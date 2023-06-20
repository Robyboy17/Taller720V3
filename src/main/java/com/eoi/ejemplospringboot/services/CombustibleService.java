package com.eoi.ejemplospringboot.services;

import com.eoi.ejemplospringboot.entities.Combustible;
import com.eoi.ejemplospringboot.repositories.CombustibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CombustibleService {

    private final CombustibleRepository repository;

    @Autowired
    public CombustibleService(CombustibleRepository repository) {
        this.repository = repository;
    }

    public List<Combustible> findAll() {
        return repository.findAll();
    }

    public Optional<Combustible> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteCombustibleById(Long id) {
        boolean exist = repository.existsById(id);
        if (!exist) {
            throw new IllegalStateException("El combutible con el id" +
                    id + " no existe");
        }
        repository.deleteById(id);
    }

    public void createCombustible(Combustible combustible) {
        repository.save(combustible);
    }

    public void updateCombustible(Combustible combustible) {
        Combustible combustibleDb = repository.findById(combustible.getId())
                .orElseThrow(() -> new IllegalStateException(
                        "El combustible con el " + combustible.getId() + " no existe"));

        if (combustible.getNombre() != null &&
                combustible.getNombre().length() > 0 &&
                !Objects.equals(combustibleDb.getNombre(), combustible.getNombre())) {
         combustible.setNombre(combustible.getNombre());
        }
        repository.save(combustible);
    }
    public Page<Combustible> getAllCombustiblesPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }


}
