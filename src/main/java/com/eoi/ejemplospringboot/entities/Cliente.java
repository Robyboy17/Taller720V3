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
//@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String apellido;

    private String direccion;

    /**
     * Usuario asociado al Cliente.
     */
    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;


    @ManyToMany
    @JoinColumn(name = "empresa_id")
    private List<Empresa> empresas;

}
