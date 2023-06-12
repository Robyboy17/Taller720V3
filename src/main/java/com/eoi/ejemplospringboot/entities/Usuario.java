package com.eoi.ejemplospringboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Clase que representa a un Usuario en el sistema.
 * Un Usuario puede estar asociado a uno o varios roles y, opcionalmente, a un Empleado.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nombre de usuario del Usuario.
     */
    private String username;

    private String password;

    /**
     * Nombre del Usuario.
     */
    private String nombre;

    /**
     * Apellido del Usuario.
     */
    private String apellido;

    private String email;

    private String imageUrl;


    /**
     * Fecha de Nacimiento del usuario.
     *
     * <p>
     * El formato de fecha utilizado sigue el estándar ISO 8601 (ISO DATE) "yyyy-MM-dd",
     * que es un formato ampliamente aceptado y utilizado para representar fechas.
     * Este formato garantiza la consistencia en el intercambio de información de fechas
     * y facilita la interoperabilidad con otros sistemas.
     * </p>
     *
     * <p>
     * Para más detalles sobre el formato ISO 8601 y el estándar ISO DATE, puedes consultar
     * el siguiente enlace: {@link <a href="https://www.iso.org/iso-8601-date-and-time-format.html">ISO 8601</a>}
     * </p>
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaNacimiento;
    @Basic(optional = false)
    private boolean active;

    /**
     * Lista de roles asociados al Usuario.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Rol role;

    /**
     * Empleado asociado al Usuario (opcional).
     */
    @OneToOne(optional = true)
    private Empleado empleado;

}

