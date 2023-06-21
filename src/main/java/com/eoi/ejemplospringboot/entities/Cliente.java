package com.eoi.ejemplospringboot.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellidos")
    private String apellido;

    @Column
    private String DNI;

    @Column(name = "Teléfono")
    private Integer telefono;

    @Column(name = "Email")
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonManagedReference
    private Set<Coche> coches;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reparacion> reparaciones;

    public void addCoche(Coche coche) {
        coches.add(coche);
        coche.setCliente(this);
    }

    public void removeCoche(Coche coche) {
        coches.remove(coche);
        coche.setCliente(null);
    }

}
