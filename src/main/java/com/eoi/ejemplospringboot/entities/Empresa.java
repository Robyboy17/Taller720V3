package com.eoi.ejemplospringboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String direccion;

    /**
     * Lista de clientes asociados a la Empresa.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Cliente> clientes;

    /**
     * Lista de empleados asociados a la Empresa.
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<Empleado> empleados;

    // Otras propiedades específicas de Empresa

}
