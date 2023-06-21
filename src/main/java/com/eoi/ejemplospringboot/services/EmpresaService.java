package com.eoi.ejemplospringboot.services;

import com.eoi.ejemplospringboot.entities.Cliente;
import com.eoi.ejemplospringboot.entities.Empresa;
import com.eoi.ejemplospringboot.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmpresaService {

    private final EmpresaRepository repository;

    @Autowired
    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public List<Empresa> findAll() {
        return repository.findAll();
    }

    public Optional<Empresa> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteEmpresaById(Integer empresaId) {
        boolean exists = repository.existsById(empresaId);
        if (!exists) {
            throw new IllegalStateException("La empresa con el " + empresaId + " no existe");
        }
        repository.deleteById(empresaId);
    }

    public void createEmpresa(Empresa empresa) {
        repository.save(empresa);
    }

    public void updateEmpresa(Empresa empresa) {
        Empresa empresaDb = repository.findById((int) empresa.getId())
                .orElseThrow(() -> new IllegalStateException(
                        "La empresa con el " + empresa.getId() + " no existe"));

        if (empresa.getName() != null &&
                empresa.getName().length() > 0 &&
                !Objects.equals(empresaDb.getName(), empresa.getName())) {
            empresa.setName(empresa.getName());
        }

        if (empresa.getSociedad() != null &&
                empresa.getSociedad().length() > 0 &&
                !Objects.equals(empresaDb.getSociedad(), empresa.getSociedad())) {
            empresa.setSociedad(empresa.getSociedad());
        }
        if (empresa.getDireccion() != null &&
                empresa.getDireccion().length() > 0 &&
                !Objects.equals(empresaDb.getDireccion(), empresa.getDireccion())) {
            empresa.setDireccion(empresa.getDireccion());
        }
        if (empresa.getCodigo_postal() != null &&
                empresa.getCodigo_postal().length() > 0 &&
                !Objects.equals(empresaDb.getCodigo_postal(), empresa.getCodigo_postal())) {
            empresa.setCodigo_postal(empresa.getCodigo_postal());
        }
        if (empresa.getTelefono() != null &&
                empresa.getTelefono().length() > 0 &&
                !Objects.equals(empresaDb.getTelefono(), empresa.getTelefono())) {
            empresa.setTelefono(empresa.getTelefono());
        }
        if (empresa.getEmail() != null &&
                empresa.getEmail().length() > 0 &&
                !Objects.equals(empresaDb.getEmail(), empresa.getEmail())) {
            empresa.setEmail(empresa.getEmail());
        }
        if (empresa.getWeb() != null &&
                empresa.getWeb().length() > 0 &&
                !Objects.equals(empresaDb.getWeb(), empresa.getWeb())) {
            empresa.setWeb(empresa.getWeb());
        }


        repository.save(empresa);
    }
    public Page<Empresa> getAllEmpresasPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
