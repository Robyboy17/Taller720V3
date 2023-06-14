package com.eoi.ejemplospringboot.config;

import com.eoi.ejemplospringboot.entities.Rol;
import com.eoi.ejemplospringboot.entities.Usuario;
import com.eoi.ejemplospringboot.repositories.RolRepository;
import com.eoi.ejemplospringboot.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * La clase {@code ConfiguracionInicial} es un componente de Spring que implementa la interfaz {@code
 * ApplicationListener<ContextRefreshedEvent>}. Se utiliza para realizar la configuración inicial de permisos, roles y
 * usuarios en la aplicación cuando el contexto de la aplicación se ha inicializado o actualizado.
 *
 * <p>Al implementar {@code ApplicationListener<ContextRefreshedEvent>}, la clase escucha el evento {@code
 * ContextRefreshedEvent}, que se desencadena cuando el contexto de la aplicación se ha inicializado o actualizado.
 * Dentro del método {@code onApplicationEvent}, se realizan las operaciones de configuración inicial utilizando
 * transacciones para garantizar la consistencia y la integridad de los datos.
 *
 * <p>La anotación {@code @Transactional} se utiliza en los métodos relevantes de la clase. Al anotar estos métodos, se
 * establece un contexto transaccional para las operaciones de base de datos realizadas en ellos. Esto asegura que todas
 * las operaciones se realicen en una única transacción, permitiendo el rollback de transacciones en caso de excepciones.
 *
 * <p>En resumen, la clase {@code ConfiguracionInicial} se encarga de realizar la configuración inicial de permisos,
 * roles y usuarios en la aplicación, asegurando la consistencia de los datos y utilizando transacciones para el manejo
 * de operaciones de base de datos.
 *
 * <p>La funcionalidad original para esta clase se ha obtenido de: https://www.baeldung.com/role-and-privilege-for-spring-security-registration
 *
 */
@Component
public class ConfiguracionInicial implements ApplicationListener<ContextRefreshedEvent> {

    boolean configuracionRealizada = false;

    @Autowired
    private UsuarioRepository repositorioUsuario;

    @Autowired
    private RolRepository repositorioRol;

    @Autowired
    private PasswordEncoder codificadorContraseñas;

         /**
         * Método que se ejecuta cuando se produce un evento de ContextRefreshedEvent.
         * El evento se desencadena cuando el contexto de la aplicación se ha inicializado o actualizado.
         * Realiza la configuración inicial de permisos, roles y usuarios si la configuración aún no se ha realizado.
         * En este caso, se utiliza para realizar acciones de configuración inicial cuando el contexto se refresca.
         *
         * @param event el evento de ContextRefreshedEvent que se ha producido.
         *
         */
        @Override
        @Profile("local")
        @Transactional
        public void onApplicationEvent(ContextRefreshedEvent event) {
            if (configuracionRealizada)
                return;

            Rol rolAdmin = repositorioRol.findByName("ROLE_ADMIN");
            Usuario usuario = new Usuario();
            usuario.setNombre("Admin");
            usuario.setApellido("ApellidoAdmin");
            usuario.setPassword(codificadorContraseñas.encode("test"));
            usuario.setEmail("admin@test.com");
            usuario.setUsername("admin@test.com");
            usuario.setImageUrl("images/Example.svg");
            usuario.setRole(rolAdmin);
            usuario.setActive(true);
            repositorioUsuario.save(usuario);

            Rol rolUsuario = repositorioRol.findByName("ROLE_USUARIO");
            Usuario usuario2 = new Usuario();
            usuario2.setNombre("User");
            usuario2.setApellido("ApellidoUser");
            usuario2.setPassword(codificadorContraseñas.encode("test"));
            usuario2.setEmail("user@test.com");
            usuario2.setUsername("user@test.com");
            usuario2.setImageUrl("images/Example.svg");
            usuario2.setRole(rolUsuario);
            usuario.setActive(true);
            repositorioUsuario.save(usuario2);


            configuracionRealizada = true;
        }

        /**
         * Crea un permiso si no existe en el repositorio de permisos.
         *
         * @param nombre el nombre del permiso.
         * @return el permiso existente o el nuevo permiso creado.
         */


        /**
         * Crea un rol si no existe en el repositorio de roles.
         *
         * @param nombre   el nombre del rol.
         * @param permisos la colección de permisos asociados al rol.
         * @return el rol existente o el nuevo rol creado.
         */
}

