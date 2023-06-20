package com.eoi.ejemplospringboot.services;

import com.eoi.ejemplospringboot.entities.Cliente;
import com.eoi.ejemplospringboot.entities.Marca;
import com.eoi.ejemplospringboot.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MarcaService {

    private final MarcaRepository repository;

    @Autowired
    public MarcaService(MarcaRepository repository) {
        this.repository = repository;
    }

    public List<Marca> findAll() {
        return repository.findAll();
    }

    public Optional<Marca> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteMarcaById(Integer marcaId) {
        boolean exists = repository.existsById(marcaId);
        if (!exists) {
            throw new IllegalStateException("La marca con el " + marcaId + " no existe");
        }
        repository.deleteById(marcaId);
    }

    public void createMarca(Marca marca) {
        repository.save(marca);
    }

    public void updateMarca(Marca marca) {
        Marca marcaDb = repository.findById(marca.getId())
                .orElseThrow(() -> new IllegalStateException(
                        "La marca con el " + marca.getId() + " no existe"));


        if (marca.getNombre() != null &&
                marca.getNombre().length() > 0 &&
                !Objects.equals(marcaDb.getNombre(), marca.getNombre())) {
            marca.setNombre(marca.getNombre());
        }
        repository.save(marca);
    }
    public Page<Marca> getAllMarcasPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
