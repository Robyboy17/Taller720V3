package com.eoi.ejemplospringboot.services;

import com.eoi.ejemplospringboot.entities.Empleado;
import com.eoi.ejemplospringboot.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmpleadoService {
    private final EmpleadoRepository repository;

    @Autowired
    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public List<Empleado> findAll() {
        return repository.findAll();
    }

    public Optional<Empleado> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteEmpleadoById(Integer empleadoId) {
        boolean exists = repository.existsById(empleadoId);
        if (!exists) {
            throw new IllegalStateException("El empleado con el " + empleadoId + " no existe");
        }
        repository.deleteById(empleadoId);
    }

    public void createEmpleado(Empleado empleado) {
        repository.save(empleado);
    }

    public void updateEmpleado(Empleado empleado) {
        Empleado empleadoDb = repository.findById(empleado.getId())
                .orElseThrow(() -> new IllegalStateException(
                        "El empleado con el " + empleado.getId() + " no existe"));

        if (empleado.getNombre() != null &&
                empleado.getNombre().length() > 0 &&
                !Objects.equals(empleadoDb.getNombre(), empleado.getNombre())) {
            empleado.setNombre(empleado.getNombre());
        }

        if (empleado.getApellido() != null &&
                empleado.getApellido().length() > 0 &&
                !Objects.equals(empleadoDb.getApellido(), empleado.getApellido())) {
            empleado.setApellido(empleado.getApellido());
        }

        if (empleado.getCargo() != null &&
                empleado.getCargo().length() > 0 &&
                !Objects.equals(empleadoDb.getCargo(), empleado.getCargo())) {
            empleado.setCargo(empleado.getCargo());
        }
        repository.save(empleado);
    }
}
