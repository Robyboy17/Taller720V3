//package com.eoi.ejemplospringboot.entities;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//public class Empleado {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    private String nombre;
//
//    private String apellido;
//
//    private String cargo;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private Usuario usuario;
//
//    @ManyToOne
//    private Empresa empresa;
//
//
//    public Empleado(String nombre) {
//        this.nombre = nombre;
//    }
//}
