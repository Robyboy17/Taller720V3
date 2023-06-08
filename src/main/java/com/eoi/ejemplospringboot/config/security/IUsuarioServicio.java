package com.eoi.ejemplospringboot.config.security;


import com.eoi.ejemplospringboot.entities.Usuario;

public interface IUsuarioServicio {
    public String getEncodedPassword(Usuario usuario);
}
