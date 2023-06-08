package com.eoi.ejemplospringboot.calendario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiaDelCalendario {


    private boolean diaNulo = false;

    private LocalDate fecha;

    List<Evento> eventos;

}
