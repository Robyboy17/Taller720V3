package com.eoi.ejemplospringboot.services;

import com.eoi.ejemplospringboot.entities.Cliente;
import com.eoi.ejemplospringboot.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ClienteService {

    private final ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    // READ
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Optional<Cliente> findById(Integer id) {
        return repository.findById(id);
    }

    //DELETE
    public void deleteClienteById(Integer clienteId) {
        boolean exists = repository.existsById(clienteId);
        if (!exists) {
            throw new IllegalStateException("El cliente con el " + clienteId + " no existe");
        }
        repository.deleteById(clienteId);
    }

    //CREATE
    public void createCliente(Cliente cliente) {
        repository.save(cliente);
    }

    //UPDATE
    public void updateCliente(Cliente cliente) {
        Cliente clienteDb = repository.findById(cliente.getId())
                .orElseThrow(() -> new IllegalStateException(
                        "El cliente con el " + cliente.getId() + " no existe"));

        if (cliente.getTelefono() != null &&
                !Objects.equals(clienteDb.getTelefono(), cliente.getTelefono())) {
            cliente.setTelefono(cliente.getTelefono());
        }

        if (cliente.getApellido() != null &&
                cliente.getApellido().length() > 0 &&
                !Objects.equals(clienteDb.getApellido(), cliente.getApellido())) {
            cliente.setApellido(cliente.getApellido());
        }

        if (cliente.getNombre() != null &&
                cliente.getNombre().length() > 0 &&
                !Objects.equals(clienteDb.getNombre(), cliente.getNombre())) {
            cliente.setNombre(cliente.getNombre());
        }

        if (cliente.getDNI() != null &&
                cliente.getDNI().length() > 0 &&
                !Objects.equals(clienteDb.getDNI(), cliente.getDNI())) {
            cliente.setDNI(cliente.getDNI());
        }

        if (cliente.getEmail() != null &&
                cliente.getEmail().length() > 0 &&
                !Objects.equals(clienteDb.getEmail(), cliente.getEmail())) {
            cliente.setEmail(cliente.getEmail());
        }
    }

    public List<Cliente> getAllClientes() {
        return repository.findAll();
    }
}
