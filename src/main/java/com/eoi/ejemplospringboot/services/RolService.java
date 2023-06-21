package com.eoi.ejemplospringboot.services;

import com.eoi.ejemplospringboot.entities.Cliente;
import com.eoi.ejemplospringboot.entities.Rol;
import com.eoi.ejemplospringboot.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RolService {

    private final RolRepository repository;

    @Autowired
    public RolService(RolRepository repository) {
        this.repository = repository;
    }

    public List<Rol> findAll() {
        return repository.findAll();
    }

    public Optional<Rol> findById(String id) {
        return repository.findById(id);
    }

    public void deleteRolById(String rolId) {
        boolean exists = repository.existsById(rolId);
        if (!exists) {
            throw new IllegalStateException("El rol con el " + rolId + " no existe");
        }
        repository.deleteById(rolId);
    }

    public void createRol(Rol rol) {
        repository.save(rol);
    }

    public void updateRol(Rol rol) {
        Rol rolDb = repository.findById( rol.getId())
                .orElseThrow(() -> new IllegalStateException(
                        "El rol con el " + rol.getId() + " no existe"));

        if (rol.getName() != null &&
                rol.getName().length() > 0 &&
                !Objects.equals(rolDb.getName(), rol.getName())) {
            rol.setName(rol.getName());
        }


        repository.save(rol);
    }
    public Page<Rol> getAllRolesPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
