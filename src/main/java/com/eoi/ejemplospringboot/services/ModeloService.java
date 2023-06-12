package com.eoi.ejemplospringboot.services;

import com.eoi.ejemplospringboot.entities.Modelo;
import com.eoi.ejemplospringboot.repositories.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ModeloService {

    private final ModeloRepository repository;

    @Autowired
    public ModeloService(ModeloRepository repository) {
        this.repository = repository;
    }

    public List<Modelo> findAll() {
        return repository.findAll();
    }

    public Optional<Modelo> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteModeloById(Integer modeloId) {
        boolean exists = repository.existsById(modeloId);
        if (!exists) {
            throw new IllegalStateException("El modelo con el " + modeloId + " no existe");
        }
        repository.deleteById(modeloId);
    }

    public void createModelo(Modelo modelo) {
        repository.save(modelo);
    }

    public void updateModelo(Modelo modelo) {
        Modelo modeloDb = repository.findById(modelo.getId())
                .orElseThrow(() -> new IllegalStateException(
                        "El modelo con el " + modelo.getId() + " no existe"));
        if (modelo.getNombre() != null &&
                modelo.getNombre().length() > 0 &&
                !Objects.equals(modeloDb.getNombre(), modelo.getNombre())) {
            modelo.setNombre(modelo.getNombre());
        }

        repository.save(modelo);
    }
}
