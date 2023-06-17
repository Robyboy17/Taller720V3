package com.eoi.ejemplospringboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="reparacion")
public class Reparacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // El FetchType indica cómo se cargará los datos
    // en este caso, se cargarán inmediatamente
    // de lo contrario, sería tipo LAZY en lugar de EAGER
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Usuario> usuarios;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Coche coche;

    @OneToOne
    private Empleado empleado;

    @OneToOne
    private TipoReparacion tipoReparacion;

    @Column
    private String descripcion;

    @Column
    private String duracion;

    @Column(name = "fecha_inicio")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaDeInicio;

    @Column(name = "fecha_fin")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaDeFin;

}
