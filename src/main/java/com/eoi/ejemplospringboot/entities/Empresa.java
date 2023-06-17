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
@Table(name = "empresa")
public class Empresa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name ="nombre",length = 50)
    private String name;
    @Column (name ="codigo_postal",length = 10)
    private String codigo_postal;
    @Column (name ="telefono",length = 20)
    private String telefono	;
    @Column (name ="Direccion",length = 50)
    private String direccion;
    @Column (name ="sociedad",length = 45)
    private String sociedad;
    @Column (name ="web",length = 45)
    private String web;

    @Column (name ="email",length = 45)
    private String email;

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
