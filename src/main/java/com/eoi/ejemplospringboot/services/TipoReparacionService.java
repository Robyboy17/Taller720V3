package com.eoi.ejemplospringboot.services;

import com.eoi.ejemplospringboot.entities.TipoReparacion;
import com.eoi.ejemplospringboot.repositories.TipoReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class TipoReparacionService {
    private final TipoReparacionRepository repository;

    @Autowired
    public TipoReparacionService(TipoReparacionRepository repository) {
        this.repository = repository;
    }

    public List<TipoReparacion> findAll() {
        return repository.findAll();
    }

    public Optional<TipoReparacion> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteTipoReparacionById(Integer tipoReparacionId) {
        boolean exists = repository.existsById(tipoReparacionId);
        if (!exists) {
            throw new IllegalStateException("El tipo de reparación con el " + tipoReparacionId + " no existe");
        }
        repository.deleteById(tipoReparacionId);
    }

    public void createTipoReparacion(TipoReparacion tipoReparacion) {
        repository.save(tipoReparacion);
    }

    public void updateTipoReparacion(TipoReparacion tipoReparacion) {
        TipoReparacion tipoReparacionDb = repository.findById(tipoReparacion.getId())
                .orElseThrow(() -> new IllegalStateException(
                        "El tipo de reparación con el " + tipoReparacion.getId() + " no existe"));

        if (tipoReparacion.getNombre() != null &&
                tipoReparacion.getNombre().length() > 0 &&
                !Objects.equals(tipoReparacionDb.getNombre(), tipoReparacion.getNombre())) {
            tipoReparacion.setNombre(tipoReparacion.getNombre());
        }

        repository.save(tipoReparacion);
    }
}
