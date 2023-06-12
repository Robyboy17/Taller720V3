package com.eoi.ejemplospringboot.services;


import com.eoi.ejemplospringboot.entities.Reparacion;
import com.eoi.ejemplospringboot.repositories.ReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReparacionService {

    private final ReparacionRepository repository;
    @Autowired
    public ReparacionService(ReparacionRepository repository) {
        this.repository = repository;
    }

    // READ
    public List<Reparacion> findAll() {
        return repository.findAll();
    }

    public Optional<Reparacion> findById(Integer id) {
        return repository.findById(id);
    }


    // DELETE
    public void deleteReparacionById(Integer reparacionId) {
        boolean exists = repository.existsById(reparacionId);
        if (!exists) {
            throw new IllegalStateException("La reparacion con el " +
                    reparacionId + " no existe");
        }
        repository.deleteById(reparacionId);
    }

    // CREATE
    public void createReparacion(Reparacion reparacion) {
        repository.save(reparacion);
    }

    // UPDATE
    public void updateReparacion(Reparacion reparacion) {
        Reparacion reparacionDb = repository.findById(reparacion.getId())
                .orElseThrow(() -> new IllegalStateException(
                        "La reparacion con el " + reparacion.getId() + " no existe"));
        if (reparacion.getDescripcion() != null &&
                reparacion.getDescripcion().length() > 0 &&
                !Objects.equals(reparacionDb.getDescripcion(), reparacion.getDescripcion())) {
            reparacion.setDescripcion(reparacion.getDescripcion());
        }

        if (reparacion.getDuracion() != null &&
                !Objects.equals(reparacionDb.getDuracion(), reparacion.getDuracion())) {
            reparacion.setDuracion(reparacion.getDuracion());
        }
        repository.save(reparacion);
    }
}
