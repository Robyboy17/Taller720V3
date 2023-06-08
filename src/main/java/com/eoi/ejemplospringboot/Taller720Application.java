package com.eoi.ejemplospringboot;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot.
 *
 * La anotación @SpringBootApplication se utiliza para marcar la clase principal de la aplicación Spring Boot.
 * Esta anotación combina múltiples anotaciones, como @Configuration, @EnableAutoConfiguration y @ComponentScan
 * para proporcionar una configuración y arranque automáticos de la aplicación Spring Boot.
 * Proporciona una forma conveniente de configurar y lanzar una aplicación Spring Boot sin la necesidad
 * de una configuración manual exhaustiva.
 * @Author Alejandro Teixeira Muñoz
 */
@SpringBootApplication
@AutoConfiguration
public class Taller720Application {

	/**
	 * Punto de entrada principal de la aplicación.
	 *
	 * @param args los argumentos de línea de comandos
	 * @Author Alejandro Teixeira Muñoz
	 */
	public static void main(String[] args) {
		SpringApplication.run(Taller720Application.class, args);
	}


	/**
	 *
	 * Método para iniciar los valores o configuraciones por defecto de la aplicación. La anotación @PostConstruct
	 * indica a Spring que el método se debe ejecutar inmediatamente después de la construcción de la clase.
	 * @Author Alejandro Teixeira Muñoz
	 */
	@PostConstruct
	public void init() {

		//No se requiere inicialización en este punto por el momento.

	}
}

