package com.eoi.ejemplospringboot.services;

import com.eoi.ejemplospringboot.entities.Usuario;
import com.eoi.ejemplospringboot.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Page<Usuario> findAll(Pageable pageable) {
        return (Page<Usuario>) repository.findAll();
    }

    public Optional<Usuario> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteUsuarioById(Integer usuarioId) {
        boolean exists = repository.existsById(usuarioId);
        if (!exists) {
            throw new IllegalStateException("El usuario con el " + usuarioId + " no existe");
        }
        repository.deleteById(usuarioId);
    }

    public void createUsuario(Usuario usuario) {
        repository.save(usuario);
    }

    public void updateUsuario(Usuario usuario) {
        Usuario usuarioDb = repository.findById(usuario.getId())
                .orElseThrow(() -> new IllegalStateException(
                        "El usuario con el " + usuario.getId() + " no existe"));

        if (usuario.getUsername() != null &&
                usuario.getUsername().length() > 0 &&
                !Objects.equals(usuarioDb.getUsername(), usuario.getUsername())) {
            usuario.setUsername(usuario.getUsername());
        }

        if (usuario.getApellido() != null &&
                usuario.getApellido().length() > 0 &&
                !Objects.equals(usuarioDb.getApellido(), usuario.getApellido())) {
            usuario.setApellido(usuario.getApellido());
        }

        if (usuario.getNombre() != null &&
                usuario.getNombre().length() > 0 &&
                !Objects.equals(usuarioDb.getNombre(), usuario.getNombre())) {
            usuario.setNombre(usuario.getNombre());
        }

        if (usuario.getFechaNacimiento() != null &&
                !Objects.equals(usuarioDb.getFechaNacimiento(), usuario.getFechaNacimiento())) {
            usuario.setFechaNacimiento(usuario.getFechaNacimiento());
        }
        repository.save(usuario);
    }
}
