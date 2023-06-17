package com.eoi.ejemplospringboot.services;

import com.eoi.ejemplospringboot.entities.Cliente;
import com.eoi.ejemplospringboot.entities.Coche;
import com.eoi.ejemplospringboot.repositories.ClienteRepository;
import com.eoi.ejemplospringboot.repositories.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CocheService {

    private final CocheRepository repository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public CocheService(CocheRepository repository, ClienteRepository clienteRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }

    public List<Coche> findAll() {
        return repository.findAll();
    }

    public Optional<Coche> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteCocheById(Long id) {
        boolean exist = repository.existsById(id);
        if (!exist) {
            throw new IllegalStateException("El coche con el id " +
                    id + " no existe");
        }
        repository.deleteById(id);
    }

    public void createCoche(Coche coche) {
        repository.save(coche);
    }

    public void updateCoche(Coche coche) {
        Coche cocheDb = repository.findById(coche.getId())
                .orElseThrow(() -> new IllegalStateException(
                        "El coche con el id " + coche.getId() + " no existe"));

        repository.save(coche);
    }

    public List<Coche> getCochesByClienteId(Integer clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        if (cliente != null) {
            return new ArrayList<>(cliente.getCoches());
        } else {
            return new ArrayList<>();
        }
    }
}
