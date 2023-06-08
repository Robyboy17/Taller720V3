# Proyecto de ejemplo Springboot EOI

## Introducción

El Proyecto de Ejemplo Spring Boot EOI es una aplicación guía diseñada para facilitar el aprendizaje de Spring Boot, un poderoso framework de desarrollo de aplicaciones Java. Spring Boot simplifica la creación de aplicaciones empresariales, proporcionando una configuración predefinida y una estructura de proyecto fácil de seguir.

Este proyecto de ejemplo utiliza Spring Boot 3.0.7, una versión estable y confiable de Spring Boot en el momento de su desarrollo. Además, se emplean tecnologías y herramientas adicionales como Maven para la gestión de dependencias y el empaquetado en formato JAR, y Java 20 como el lenguaje de programación principal.

Para el desarrollo de esta aplicación, se recomienda el uso del entorno de desarrollo IntelliJ IDEA, conocido por su amplio conjunto de características y facilidades para el desarrollo de aplicaciones Java. También se sugiere la instalación de algunos plugins, como Docker para la gestión de contenedores, JPA Buddy para mejorar la experiencia de desarrollo con JPA y Database Navigator para explorar y administrar bases de datos directamente desde el IDE.




## Software utilizado

En este proyecto, se utilizan las siguientes tecnologías:

- [Spring Boot 3.0.7](https://spring.io/projects/spring-boot): Spring Boot es un framework de desarrollo de aplicaciones Java que facilita la creación de aplicaciones empresariales. La versión 3.0.7 es la utilizada en este proyecto.

- [Maven](https://maven.apache.org/): Maven es una herramienta de gestión de dependencias y construcción de proyectos. Se utiliza para gestionar las dependencias del proyecto y para empacar la aplicación en formato JAR.

- JAR Packaging: El empaquetado en formato JAR es una forma común de distribuir aplicaciones Java. En este proyecto, se utiliza JAR Packaging para empaquetar la aplicación y hacerla fácilmente ejecutable.

- [Java 20](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html): Java 20 es la versión de Java utilizada en este proyecto. Java es un lenguaje de programación ampliamente utilizado para el desarrollo de aplicaciones.


## Configurar el entorno de desarrollo local

Sigue estos pasos para configurar tu entorno de desarrollo local:

### 1. Instalar IntelliJ IDEA

- Descarga [IntelliJ IDEA](https://www.jetbrains.com/idea/) desde el sitio web oficial.
- Sigue las instrucciones de instalación para tu sistema operativo.
- Una vez instalado, ábrelo y configura tu entorno de trabajo según tus preferencias.

### 2. Instalar los plugins indicados

Para aprovechar al máximo el desarrollo en este proyecto, se recomienda instalar los siguientes plugins en IntelliJ IDEA:

- **Docker**: Este plugin te permite gestionar y administrar contenedores Docker directamente desde el IDE, lo que facilita la integración de tus aplicaciones con Docker.
- **JPA Buddy**: El plugin JPA Buddy mejora la experiencia de desarrollo al proporcionar características específicas para trabajar con JPA (Java Persistence API) en tu proyecto.
- **Database Navigator**: Este plugin te permite explorar y administrar bases de datos directamente desde el IDE, lo que facilita la interacción con tu base de datos durante el desarrollo.
- **SonarLint**: SonarLint te ayudará a detectar errores y defectos de programación en el código, consiguiendo siempre que calidad y seguridad lleguen a los estándares más altos.

### 3. Instalar Docker Desktop

- Descarga [Docker Desktop](https://www.docker.com/products/docker-desktop) según tu sistema operativo.
- Sigue las instrucciones de instalación para tu sistema operativo.
- Una vez instalado, asegúrate de que Docker esté en funcionamiento y configurado correctamente en tu entorno.

Asegúrate de seguir estos pasos para configurar tu entorno de desarrollo local antes de comenzar a trabajar en el proyecto. Esto te permitirá aprovechar al máximo las herramientas y los recursos necesarios para el desarrollo exitoso del proyecto.


## Hacer un Fork del Proyecto

Puedes crear tu propio proyecto spring desde cero desde este link de spring initializer: 

[Spring project](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.0.7&packaging=jar&jvmVersion=20&groupId=com.eoi&artifactId=springboot&name=springboot&description=Proyecto%20Gu%C3%ADa%20de%20Springboot&packageName=com.eoi.springboot&dependencies=devtools,lombok,configuration-processor,web)

Ese modelo contiene únicamente las dependencias básicas y viene únicamente con la aplicación inicial de SpringBoot.  Puedes utilizarlo como base para trabajar pero deberás seguir los mismos pasos que se siguieron en el proyecto de ejemplo de springboot.



Para hacer un fork del repositorio de ejemplo en GitHub y poder abrirlo en IntelliJ para comparar, sigue estos pasos:

1. Navega hasta el repositorio original en GitHub: [ateixeiramunoz/ejemplospringboot](https://github.com/ateixeiramunoz/ejemplospringboot).
2. Haz clic en el botón "Fork" en la parte superior derecha del repositorio.
3. Selecciona tu cuenta de GitHub como destino para el fork.

Una vez completado, tendrás un nuevo repositorio en tu cuenta de GitHub que es una copia del repositorio original. Ahora puedes clonar este fork en tu entorno local y realizar modificaciones según tus necesidades.

## Actualizar el Fork desde la Versión Principal

Para mantener tu fork actualizado con la versión principal en GitHub, puedes seguir estos pasos:

1. Clona tu fork en tu entorno local utilizando el comando 
2. `git clone` o una herramienta Git de tu elección.

3. Agrega el repositorio original como un control remoto adicional utilizando el comando 
   ```shell
   git remote add upstream https://github.com/ateixeiramunoz/ejemplospringboot
   ```   
Esto establecerá una conexión entre tu fork y el repositorio original.


4. Verifica los remotos configurados en tu repositorio local utilizando el comando
   ```shell
   git remote -v
   ```
5. Deberías ver tu fork (origin) y el repositorio original (upstream).
6. Para actualizar tu fork, primero debes obtener los cambios del repositorio original ejecutando

   ```shell
   git fetch upstream
   ```
Esto traerá las últimas actualizaciones al repositorio local.
   
7. Después de obtener los cambios, puedes combinarlos con tu rama principal utilizando
   ```shell
   git merge upstream/main
   ```
   **¡¡¡Asegúrate de estar en tu rama principal antes de ejecutar este comando!!!!!**

 
8. Si hay conflictos durante la fusión, resuélvelos manualmente editando los archivos afectados.
9. Finalmente, empuja los cambios actualizados a tu fork en GitHub utilizando `git push origin <nombre-de-tu-rama>`.

Con estos pasos, tu fork estará actualizado con los cambios más recientes del repositorio original en GitHub. Puedes repetir este proceso siempre que desees sincronizar tu fork con la versión principal.




## Ejecución del proyecto

Por defecto, el proyecto está configurado para lanzar el perfil "local", el cual utiliza una base de datos H2 en memoria. Esto permite ejecutar la aplicación sin necesidad de configurar una base de datos externa.

Sin embargo, si se elige el perfil "dev", se seleccionará un sistema de conexión en el que deberemos informar las variables de entorno de la base de datos o conectar a una base de datos local de MySQL por defecto. Esto proporciona flexibilidad para utilizar una base de datos más robusta y adecuada para entornos de desarrollo.

La ejecución del proyecto se realiza mediante la configuración de ciertas variables de entorno, que permiten adaptar la aplicación a diferentes escenarios. Estas variables incluyen SPRING_PROFILE para definir el perfil de ejecución, DATABASE_TYPE para especificar el tipo de base de datos a utilizar, DATABASE_NAME para el nombre de la base de datos, DATABASE_USERNAME y DATABASE_PASSWORD para las credenciales de acceso, y DATABASE_HOST y DATABASE_PORT para la ubicación y el puerto del servidor de la base de datos. Además, DATABASE_DRIVER se utiliza para indicar el controlador de la base de datos.

Con el Proyecto de Ejemplo Spring Boot EOI, podrás familiarizarte con los conceptos fundamentales de Spring Boot, incluyendo la configuración automática, la gestión de dependencias, el acceso a bases de datos mediante JPA, entre otros. A través de su estructura organizada y su configuración predefinida, este proyecto te servirá como punto de partida para tus propias aplicaciones basadas en Spring Boot.




## Ejecución del Proyecto en IntelliJ

Sigue estos pasos para ejecutar el proyecto `EjemplospringbootApplication` en IntelliJ:

1. Abre IntelliJ IDEA y selecciona "Open" en la pantalla de inicio.
2. Navega hasta la carpeta del proyecto descargado y haz clic en "Open" para abrirlo en IntelliJ.
3. Espera a que IntelliJ importe y configure el proyecto.
4. Una vez que el proyecto se haya cargado correctamente, busca la clase `EjemplospringbootApplication`. Puedes encontrarla en la ruta `src/main/java/com/eoi/ejemplospringboot/EjemplospringbootApplication.java`.
5. Haz clic derecho en la clase `EjemplospringbootApplication` y selecciona Run 'EjemplospringbootApplication'" para ejecutar la aplicación.
6. IntelliJ compilará y construirá el proyecto, y la aplicación se iniciará.

Si estás utilizando el perfil "local", la aplicación se ejecutará con una base de datos H2 en memoria por defecto. Si deseas utilizar el perfil "dev" con una base de datos MySQL, asegúrate de configurar las variables de entorno necesarias con los detalles de la base de datos, como se describe anteriormente.

Una vez que la aplicación se haya iniciado correctamente, puedes acceder a ella a través de un navegador web en la dirección [http://localhost:8080](http://localhost:8080) (o el puerto especificado en la configuración).

¡Disfruta explorando y probando el proyecto en IntelliJ!


## Ejecución de comandos desde este README.md

Desde este archivo README, si lo abres desde IntelliJ, podrás ejecutar directamente los comandos maven o docker que vayas viendo en la explicación, asi como lanzar las clases de la aplicacion. 


A continuación, se muestran algunos ejemplos de comandos Maven que puedes ejecutar utilizando este formato:

Si indicas nombres de clases o metodos, detecta que es la clase de la aplicación y se prepara para ejecutarla.

`EjemplospringbootApplication`  

Los comandos maven también son funcionales.

`mvn spring-boot:build-image`  

Igual que los de Docker
 ```shell
 docker -v 
 ```

   


## Integración con Docker

El proyecto trabaja con docker como sistema de contendores.

### Generacion de la imagen

Para generar la imagen Docker del proyecto, es necesario ejecutar el goal Maven del plugin spring-boot llamado build-image. Este plugin proporciona una manera conveniente de empacar la aplicación Spring Boot en una imagen Docker.

La sintaxis para ejecutar el goal Maven build-image es la siguiente:

`mvn spring-boot:build-image`


Al ejecutar este comando, Maven generará la imagen Docker del proyecto, incluyendo todas las dependencias y configuraciones necesarias. La imagen resultante se almacenará localmente y podrá ser utilizada para ejecutar contenedores Docker.

Una vez que la imagen Docker esté generada, puedes lanzar un contenedor utilizando la variable de entorno del perfil "local". Para hacerlo, debes ejecutar la siguiente sentencia:

   ```shell
   docker run --name SpringbootLOCAL -e SPRING_PROFILE=local -p 8080:8080 alejandroteixeira/spring-boot:latest
   ```

Esto levantará un contenedor docker que podrás consultar, igual que antes, en http://localhost:8080

## Perfiles de la Aplicación

En el archivo `pom.xml`, se han configurado perfiles que permiten adaptar la ejecución de la aplicación según diferentes entornos o configuraciones específicas. A continuación se detallan los perfiles disponibles:

### Perfil `local`

Este perfil está diseñado para ejecutar la aplicación en un entorno local. No requiere una base de datos externa, ya que utiliza una base de datos H2 en memoria. Es útil durante el desarrollo y las pruebas locales.

### Perfil `dev`

Este perfil está destinado a entornos de desarrollo. Utiliza una base de datos MySQL y se configura con parámetros específicos para este entorno. Puede requerir la configuración de variables de entorno o archivos de propiedades adicionales.

### Perfil `prod`

Este perfil está dirigido a entornos de producción. También utiliza una base de datos MySQL, pero se configura con parámetros específicos para el entorno de producción. Puede requerir configuraciones adicionales y consideraciones de seguridad.

Cada perfil tiene sus propias configuraciones y dependencias específicas que se definen dentro del archivo `pom.xml`. Asegúrate de ajustar estas configuraciones según tus necesidades y entorno de ejecución.

Recuerda que puedes personalizar aún más los perfiles y agregar tus propios perfiles según tus requisitos específicos.

¡Ahora puedes aprovechar los perfiles de la aplicación para adaptarla a diferentes entornos y configuraciones!



## Variables de entorno

Durante la ejecución del proyecto, se utilizan ciertas variables de entorno para adaptar la aplicación a diferentes escenarios, especialmente cuando se activan perfiles específicos. A continuación se enumeran las variables de entorno utilizadas en este proyecto, algunas de las cuales pueden ser necesarias según el perfil activo:

- `SPRING_PROFILE`: Esta variable define el perfil de ejecución de la aplicación y puede ser necesaria para cargar la configuración correspondiente a un perfil específico.
- `DATABASE_TYPE`: Esta variable especifica el tipo de base de datos que se utilizará y puede ser necesaria para configurar correctamente la conexión a la base de datos según el perfil.
- `DATABASE_NAME`: Esta variable define el nombre de la base de datos y puede ser necesaria para establecer la base de datos adecuada según el perfil.
- `DATABASE_USERNAME`: Esta variable define el nombre de usuario para acceder a la base de datos y puede ser necesaria para autenticarse en la base de datos según el perfil.
- `DATABASE_PASSWORD`: Esta variable define la contraseña para acceder a la base de datos y puede ser necesaria para autenticarse en la base de datos según el perfil.
- `DATABASE_HOST`: Esta variable define la ubicación (host) del servidor de la base de datos y puede ser necesaria para establecer la conexión con el servidor de la base de datos según el perfil.
- `DATABASE_PORT`: Esta variable define el puerto del servidor de la base de datos y puede ser necesaria para establecer la conexión con el servidor de la base de datos según el perfil.
- `DATABASE_DRIVER`: Esta variable define el controlador de la base de datos a utilizar y puede ser necesaria para cargar el controlador adecuado según el perfil.

Asegúrate de configurar correctamente estas variables de entorno según tus necesidades y el perfil activo antes de ejecutar el proyecto.



## Crear un modo de ejecución en IntelliJ con variables de entorno

Sigue estos pasos para crear un modo de ejecución en IntelliJ con las variables de entorno proporcionadas:

1. Abre IntelliJ IDEA y carga el proyecto.
2. Haz clic en la configuración de ejecución en la parte superior derecha de la ventana de IntelliJ (generalmente junto al botón de ejecución verde).
3. Selecciona "Edit Configurations" en el menú desplegable.
4. En la ventana de configuraciones, haz clic en el botón "+" en la esquina superior izquierda y selecciona "Spring Boot" en la lista de opciones.
5. En la sección "Environment", agrega las siguientes variables de entorno con los valores correspondientes:

    - Variable: `SPRING_PROFILE`
      Valor: `dev`

    - Variable: `DATABASE_TYPE`
      Valor: `mysql`

    - Variable: `DATABASE_NAME`
      Valor: `springboot`

    - Variable: `DATABASE_USERNAME`
      Valor: `root`

    - Variable: `DATABASE_PASSWORD`
      Valor: `password`

    - Variable: `DATABASE_HOST`
      Valor: `localhost`

    - Variable: `DATABASE_PORT`
      Valor: `3306`

    - Variable: `DATABASE_DRIVER`
      Valor: `com.mysql.cj.jdbc.Driver`

6. En la parte inferior de la ventana de configuraciones, selecciona la clase principal del proyecto (por ejemplo, `EjemplospringbootApplication`) como el punto de entrada.
7. Haz clic en "Apply" y luego en "OK" para guardar la configuración.

Ahora puedes ejecutar el proyecto en IntelliJ utilizando este modo de ejecución con las variables de entorno especificadas. Asegúrate de seleccionar esta configuración antes de ejecutar el proyecto para utilizar los valores proporcionados.

Recuerda que estos valores son solo un ejemplo y puedes ajustarlos según tus necesidades y configuración específica.


## Levantar un contenedor MySQL con el plugin de Docker en IntelliJ

El plugin de Docker en IntelliJ te permite gestionar y administrar contenedores Docker directamente desde el IDE, lo que facilita la integración de tus aplicaciones con Docker.

Para levantar un contenedor MySQL utilizando el plugin de Docker en IntelliJ en la ventana de servicios, puedes seguir estos pasos:

1. Asegúrate de tener el plugin de Docker instalado en IntelliJ. Si no lo tienes instalado, puedes ir a `File > Settings > Plugins` y buscar "Docker" en el Marketplace de IntelliJ para instalarlo.

2. Abre IntelliJ IDEA y carga tu proyecto.

3. Haz clic en la pestaña "Services" en la parte inferior izquierda de la ventana de IntelliJ para abrir la ventana de servicios.

4. En la ventana de servicios, haz clic derecho en la sección "Images" y selecciona la opción "Pull".

5. En el campo "Image name", ingresa `mysql:latest` para descargar la imagen más reciente de MySQL directamente desde Docker Hub.

6. Haz clic en el botón "OK" para iniciar la descarga de la imagen de MySQL.

7. Una vez descargada la imagen, haz click derecho sobre ella y selecciona la opción "Create Container".

8. En la sección "Port bindings", haz clic en el botón "+" para agregar una nueva asignación de puertos. Especifica el puerto 3036 en el campo "Host port" y el puerto 3306 en el campo "Container port".

9. En la sección "Environment variables", haz clic en el botón "+" para agregar una nueva variable de entorno. Ingresa `MYSQL_ROOT_PASSWORD` como nombre y `password` como valor.

10. Haz clic en el botón "OK" para crear el contenedor.

11. Espera a que el contenedor se inicie correctamente. Puedes verificar el estado del contenedor y los registros en la ventana de servicios.

12. Ahora, puedes conectarte al servidor de MySQL utilizando una herramienta de administración de bases de datos o ejecutando comandos SQL desde la línea de comandos.

- Host: `localhost` o `127.0.0.1`
- Puerto: `3036`
- Nombre de usuario: `root`
- Contraseña: `password`

Recuerda que este es solo un ejemplo y puedes ajustar los valores según tus necesidades, como los puertos de publicación y la contraseña de root.

¡Listo! Ahora tienes un contenedor MySQL en ejecución con la contraseña de root "password" y el puerto 3036 publicado en tu sistema utilizando el plugin de Docker en IntelliJ en la ventana de servicios.



## Ejecutar la aplicación y la base de datos en diferentes contenedores de Docker

Si deseas ejecutar la aplicación y la base de datos en diferentes contenedores de Docker en el mismo sistema, es recomendable crear una red personalizada en el plugin de Docker en IntelliJ y unir el contenedor MySQL a esa red. Esto permite una comunicación fácil y segura entre los contenedores.

Puedes seguir estos pasos para crear una red personalizada y unir el contenedor MySQL a esa red utilizando el plugin de Docker en IntelliJ:

1. Abre IntelliJ IDEA y carga tu proyecto.

2. Haz clic en la pestaña "Services" en la parte inferior izquierda de la ventana de IntelliJ para abrir la ventana de servicios.

3. En la ventana de servicios, haz clic derecho en la sección "Networks" y selecciona la opción "Create Network".

4. En la ventana emergente, ingresa un nombre para la red en el campo "Name" y haz clic en el botón "OK" para crear la red personalizada.

5. Una vez creada la red, haz clic derecho en el contenedor MySQL que creaste antes  y selecciona la opción "Edit Container Settings".

6. En la configuración del contenedor, ve a la sección "Networks" y haz clic en el botón "+" para agregar una nueva red.

7. Selecciona la red personalizada que creaste en el paso anterior y haz clic en el botón "OK" para unir el contenedor MySQL a esa red.

8. Guarda los cambios en la configuración del contenedor. Vuelve a crear el contenedor con la nueva configuración pulsando botón derecho sobre él. 

9. Ahora, puedes crear un nuevo contenedor para ejecutar la aplicación y unirlo a la misma red personalizada.

10. Para crear el contenedor de la aplicación, sigue los pasos mencionados anteriormente para crear un contenedor, pero selecciona la imagen de la aplicación y configura los puertos y variables de entorno según sea necesario. 
    
    Puedes tomar estos como ejemplo:
  
    - Variable: `SPRING_PROFILE`
      Valor: `dev`

    - Variable: `DATABASE_TYPE`
      Valor: `mysql`

    - Variable: `DATABASE_NAME`
      Valor: `springboot`

    - Variable: `DATABASE_USERNAME`
      Valor: `root`

    - Variable: `DATABASE_PASSWORD`
      Valor: `password`

    - Variable: `DATABASE_HOST`
      Valor: `localhost`

    - Variable: `DATABASE_PORT`
      Valor: `3306`

    - Variable: `DATABASE_DRIVER`
      Valor: `com.mysql.cj.jdbc.Driver`

11. En la configuración del contenedor de la aplicación, ve a la sección "Networks" y selecciona la misma red personalizada que seleccionaste para el contenedor MySQL.

12. Guarda los cambios en la configuración del contenedor de la aplicación.

13. Ahora, tanto el contenedor de la aplicación como el contenedor MySQL están conectados a la misma red personalizada, lo que les permite comunicarse entre sí.

Recuerda que este es solo un ejemplo y puedes ajustar los valores y configuraciones según tus necesidades, como los nombres de la red, las imágenes de los contenedores y las variables de entorno.

También puedes lanzar ambas directamente con los comandos:

   ```shell
   docker run -p 3306:3306 --env MYSQL_ROOT_PASSWORD=password --name mysql-server-dev --pull missing --network springboot mysql:latest
   ```

   ```shell
   docker run -p 0.0.0.0:80:8080 --env DATABASE_HOST=mysql-server-dev --env SPRING_PROFILE=dev --name SpringbootAPP-DESARROLLO --pull missing --network springboot alejandroteixeira/spring-boot:latest
   ```

¡Listo! Ahora puedes ejecutar la aplicación y la base de datos en diferentes contenedores de Docker en el mismo sistema utilizando una red personalizada.

Al ser la versión de desarrollo y no la local, en este caso la hemos publicado en el puerto 80 para diferenciarlas, por lo que podrás acceder directamente desde  [http://localhost](http://localhost)

### Ciclo de Vida de Maven

El ciclo de vida de Maven consta de una serie de fases que se ejecutan secuencialmente para construir y gestionar un proyecto. Cada fase realiza tareas específicas en el proceso de desarrollo y construcción del proyecto. A continuación se describen las principales fases del ciclo de vida de Maven:

#### clean
La fase `clean` se encarga de eliminar los archivos generados en compilaciones anteriores, como los directorios `target` y los archivos de compilación.

Comando Maven: `mvn clean`

#### validate
La fase `validate` valida la estructura y la sintaxis del proyecto para asegurarse de que es válido y que todas las dependencias necesarias están disponibles.

Comando Maven: `mvn validate`

#### compile
La fase `compile` compila los archivos fuente del proyecto y genera los archivos compilados, como los archivos `.class` para proyectos Java, en el directorio `target`.

Comando Maven: `mvn compile`

#### test
En la fase `test`, Maven ejecuta las pruebas unitarias del proyecto. Busca los archivos de prueba ubicados en el directorio `src/test` y los ejecuta utilizando un marco de pruebas como JUnit.

Comando Maven: `mvn test`

#### package
En la fase `package`, Maven empaca los archivos compilados y otros recursos necesarios en un formato específico, como un archivo JAR para proyectos Java.

Comando Maven: `mvn package`

#### verify
La fase `verify` realiza verificaciones adicionales sobre el proyecto y los resultados de las pruebas.

Comando Maven: `mvn verify`

#### install
En la fase `install`, Maven instala el artefacto en el repositorio local de Maven. Esto permite su reutilización en otros proyectos.

Comando Maven: `mvn install`

#### deploy
La fase `deploy` copia el artefacto en un repositorio remoto, como un servidor de artefactos Maven, para su distribución o uso por otros desarrolladores.

Comando Maven: `mvn deploy`

Estas son las fases principales del ciclo de vida de Maven. Cada una de ellas cumple una función específica en el proceso de construcción y gestión del proyecto. Maven permite ejecutar estas fases de forma individual o como parte del ciclo completo para llevar a cabo diversas tareas en el desarrollo de software.

La orden para lanzar el ciclo completo de Maven es simplemente ejecutar el comando:

`mvn clean deploy` 

Este comando ejecutará todas las fases del ciclo de vida de Maven, desde la fase clean hasta la fase deploy.

La fase deploy es una de las fases finales del ciclo de vida de Maven y se utiliza para publicar los artefactos del proyecto en un repositorio remoto, como un repositorio Maven corporativo o un repositorio en la nube. Esto permite compartir y distribuir el artefacto generado con otros desarrolladores o sistemas.

Es importante tener en cuenta que para ejecutar correctamente la fase deploy, es necesario configurar correctamente el repositorio remoto en el archivo settings.xml de Maven, proporcionando las credenciales de acceso y la URL del repositorio remoto.

Al ejecutar el comando mvn clean deploy, Maven ejecutará todas las fases del ciclo de vida hasta llegar a la fase deploy, donde se realizará el despliegue del artefacto en el repositorio remoto configurado.

Recuerda que para utilizar correctamente el comando mvn clean deploy, debes estar ubicado en el directorio raíz del proyecto donde se encuentra el archivo pom.xml.


## Plugins Maven

Los plugins se configuran en el archivo pom.xml y se ejecutan en fases específicas del ciclo de vida de Maven. Estos plugins nos brindan funcionalidades adicionales y nos permiten realizar diversas acciones durante el proceso de construcción, prueba y despliegue de la aplicación.

Cada plugin cumple un rol específico en el ciclo de vida de la aplicación y nos ayuda a automatizar tareas importantes. Su configuración adecuada en el archivo pom.xml nos permite aprovechar al máximo estas funcionalidades y mejorar la eficiencia de nuestro proceso de desarrollo y despliegue.



Algunos de los plugins comunes utilizados en el proyecto son:


### Plugin Docker Maven

El plugin `Docker Maven` se utiliza para interactuar con Docker desde Maven. Proporciona funcionalidades para construir, ejecutar y administrar contenedores Docker en el proceso de compilación y prueba de una aplicación.

Con este plugin, puedes:

- Construir y gestionar imágenes de Docker.
- Configurar los contenedores y las redes necesarias.
- Realizar acciones como iniciar y detener los contenedores durante diferentes fases del ciclo de vida de Maven.


### Plugin Surefire Maven

El plugin `Surefire Maven` se utiliza para ejecutar los tests unitarios en Maven. Proporciona un entorno de ejecución para las pruebas unitarias y garantiza que los resultados sean mostrados correctamente en los informes.

Con este plugin, puedes:

- Ejecutar los tests unitarios definidos en tu proyecto.
- Configurar opciones de ejecución, como patrones de inclusión y exclusión de tests.
- Ejecutar y generar informes sobre los tests unitarios, asegurando la calidad del código y detectando posibles errores.




## Plugin Failsafe Maven

El plugin `Failsafe Maven` es una extensión del plugin `Surefire Maven` que se utiliza para ejecutar los tests de integración en Maven. Proporciona un entorno separado para los tests de integración, permitiendo una mayor flexibilidad y configuración.

Con este plugin, puedes:

- Definir ejecuciones de tests de integración.
- Ejecutar pruebas que involucran componentes más grandes de la aplicación y asegura la integración correcta de los diferentes módulos.
- Especificar patrones de inclusión y exclusión de los tests.
- Verificar los resultados de los tests de integración.




# Uso de WebJars en mi proyecto

En este proyecto, estamos utilizando WebJars para gestionar las dependencias de bibliotecas web, específicamente `webjars-locator` y `bootstrap`. A continuación, explicaré cómo funciona WebJars y por qué lo estamos utilizando.

## ¿Qué es WebJars?

WebJars es un enfoque para empaquetar bibliotecas web y recursos estáticos en archivos JAR (Java Archive) para su fácil consumo en aplicaciones basadas en Maven. Proporciona una forma conveniente de administrar y utilizar bibliotecas web en proyectos Java.

## Ventajas de utilizar WebJars

- **Gestión sencilla de dependencias**: Con WebJars y Maven, puedes agregar fácilmente dependencias de bibliotecas web en tu proyecto sin tener que descargar y configurar manualmente los archivos de bibliotecas.

- **Control de versiones**: Al utilizar WebJars, puedes especificar fácilmente la versión de la biblioteca que deseas utilizar. Maven se encarga de descargar la versión específica y mantener un control estricto de las dependencias.

- **Facilidad de uso**: Los recursos de las bibliotecas web empaquetadas en WebJars son accesibles a través de rutas predefinidas y coherentes, lo que facilita su uso en tu proyecto sin tener que preocuparte por la ubicación de los archivos.


## Funcionamiento de WebJars

Cuando agregas una dependencia de WebJars a tu proyecto Maven, como `webjars-locator` y `bootstrap`, Maven se encarga de descargar automáticamente los archivos JAR correspondientes y colocarlos en el directorio `target/webjars` de tu proyecto.

## Código HTML de la aplicación para importar librerias y css desde webjars

En el código HTML, hemos agregado enlaces a los archivos de JavaScript y CSS de Bootstrap utilizando las rutas proporcionadas por WebJars. Estas rutas comienzan con `/webjars/` seguido del nombre de la biblioteca y la ubicación del archivo dentro del archivo JAR.


```markdown
<!DOCTYPE html>
<html lang="en">
<title>WebJars Demo</title>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
    <div class="content"></div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
```


Cargar el script de Bootstrap al final del archivo HTML es una práctica recomendada conocida como "deferred loading" (carga diferida). Esta práctica se utiliza para mejorar el rendimiento y la velocidad de carga de la página.

Cuando se carga el script de Bootstrap al final del archivo HTML, se permite que el contenido HTML y los estilos CSS se carguen y rendericen primero. Esto evita el bloqueo del proceso de renderizado mientras se descarga y ejecuta el script de Bootstrap.

Al cargar los estilos CSS primero, el navegador puede aplicar los estilos a medida que el contenido se va mostrando en la pantalla, lo que mejora la apariencia visual y la experiencia del usuario. Luego, al cargar el script de Bootstrap al final, se asegura de que todos los elementos de la página ya estén disponibles y listos para interactuar con el JavaScript de Bootstrap.

Esta práctica ayuda a evitar el "efecto de bloqueo de renderizado" y garantiza que la página se cargue y muestre rápidamente, proporcionando una mejor experiencia de usuario.

Es importante tener en cuenta que esta recomendación es aplicable cuando no hay dependencias críticas de JavaScript que deban cargarse antes de que se renderice el contenido principal de la página. Si tienes dependencias específicas que requieren la carga del script de Bootstrap antes, deberás ajustar la ubicación del enlace al script en consecuencia.



Principios de programación de Spring Boot y Java aplicados en la aplicación
=======================================

En esta aplicación, se han aplicado varios principios de programación de Spring Boot y Java para lograr una arquitectura sólida y un código limpio y mantenible. A continuación, se describen algunos de los principios clave que se han utilizado en la creación de las interfaces y clases abstractas mencionadas.

### Inversión de Control (IoC)

La Inversión de Control es un principio fundamental en Spring Boot que permite desacoplar las dependencias y mover la responsabilidad de la creación y gestión de objetos a un contenedor de IoC, como el contenedor de Spring. En la aplicación, se ha aplicado este principio al utilizar anotaciones como `@Autowired` para inyectar dependencias, como los repositorios, en las clases correspondientes. Esto permite que el contenedor de Spring se encargue de crear y gestionar las instancias de las dependencias necesarias.

**Ejemplo:**

```java
@Autowired
private UserRepository userRepository;
```

### Inyección de Dependencias (DI)

La Inyección de Dependencias es un patrón que se utiliza para proporcionar dependencias a un objeto en lugar de que el objeto las cree o las busque por sí mismo. En la aplicación, se ha utilizado la inyección de dependencias en diferentes clases, como en `GenericServiceWithJPA`, `MiControladorGenerico` y `UsuarioController`. Al inyectar las dependencias, como los servicios y repositorios, a través de constructores o métodos anotados con `@Autowired`, se logra un bajo acoplamiento entre las clases y se facilita la prueba y el intercambio de implementaciones.


**Inyección de Dependencias (DI)**

```java
@Autowired
public MiControladorGenerico(GenericServiceWithJPA<T, ?> service) {
    this.service = service;
}
```


### Principio de Abstracción

El Principio de Abstracción es una práctica común en la programación orientada a objetos que busca abstraer los detalles internos de una implementación y proporcionar una interfaz genérica y reutilizable. En la aplicación, se ha aplicado este principio en las interfaces `GenericService` y `GenericServiceWithJPA`, que definen métodos genéricos para realizar operaciones CRUD en entidades. Estas interfaces permiten que se reutilice el código en diferentes partes de la aplicación sin conocer los detalles específicos de la implementación.


**Principio de Abstracción**

```java
public interface GenericService<T> {
    T getById(Object id);
    T create(T entity);
    T update(Object id, T entity);
    void delete(Object id);
    List<T> listAll();
    JpaRepository<T, ?> getRepository();
}
```

### Separación de Responsabilidades

La Separación de Responsabilidades es un principio importante para mantener un código limpio y mantenible. En la aplicación, se ha buscado separar las responsabilidades mediante la creación de clases abstractas, como `GenericServiceWithJPA` y `MiControladorGenerico`, que proporcionan una implementación base para funcionalidades comunes. Estas clases abstractas encapsulan la lógica de acceso a datos y operaciones CRUD, lo que permite a las clases concretas especializadas centrarse en aspectos específicos de la aplicación.

### Herencia y Polimorfismo

El uso de herencia y polimorfismo es un principio clave en la programación orientada a objetos. En la aplicación, se ha utilizado la herencia y el polimorfismo al crear clases abstractas como `GenericServiceWithJPA` y `MiControladorGenerico`. Estas clases abstractas definen métodos comunes y proporcionan una estructura   base para que las clases concretas hereden de ellas y extiendan su funcionalidad. Esto fomenta la reutilización del código y la consistencia en la implementación de las clases concretas.

### Principios de Diseño SOLID

Se han aplicado algunos principios del diseño SOLID en la creación de las interfaces y clases abstractas. Entre ellos:

- **Principio de Responsabilidad Única (SRP)**: Cada clase tiene una única responsabilidad y un único motivo para cambiar. Las interfaces `GenericService` y `GenericServiceWithJPA` tienen la responsabilidad de definir operaciones CRUD genéricas, mientras que las clases concretas se encargan de la implementación específica.

- **Principio de Abierto/Cerrado (OCP)**: Las interfaces y clases abstractas se diseñan para ser abiertas a la extensión y cerradas a la modificación. Pueden ser extendidas por clases concretas para agregar funcionalidades adicionales sin modificar el código existente.

- **Principio de Sustitución de Liskov (LSP)**: Las clases concretas que implementan las interfaces se pueden sustituir por las interfaces base sin afectar el comportamiento de la aplicación. Esto permite el uso polimórfico de las clases y promueve la cohesión y flexibilidad.




Tratamiento de Errores en la Aplicación
=======================================

En la aplicación, se ha implementado un manejo de errores personalizado para proporcionar una respuesta adecuada a las excepciones que pueden ocurrir durante la ejecución. Esto se logra mediante el uso de las clases `CustomExceptionHandler` y `ErrorController`.

`CustomExceptionHandler` es una clase anotada con `@ControllerAdvice`, que permite manejar excepciones específicas y proporcionar una respuesta personalizada. A continuación, se describen los métodos de manejo de excepciones implementados:

- `handleEntityNotFoundException`: Maneja la excepción `EntityNotFoundException` y agrega los atributos necesarios al modelo para mostrar un mensaje descriptivo del error.
- `handleMiEntidadNoEncontradaException`: Maneja la excepción `MiEntidadNoEncontradaException` y agrega los atributos necesarios al modelo para mostrar un mensaje específico del error.
- `handleParametrosIncorrectosException`: Maneja la excepción `ParametrosIncorrectosException` y agrega los atributos necesarios al modelo para mostrar un mensaje indicando que los parámetros son incorrectos.
- `handleException`: Maneja excepciones no controladas y agrega los atributos necesarios al modelo para mostrar un mensaje genérico de error.

Además, la clase contiene la clase interna `ErrorResponse`, que se utiliza para representar la respuesta de error. Esta clase tiene atributos para el mensaje de error, el mensaje descriptivo y la causa de la excepción.

Por otro lado, la clase `ErrorController` implementa la interfaz `ErrorController` de Spring Boot y se encarga de manejar los errores generados durante la ejecución de la aplicación. El método `handleError` se utiliza para procesar las excepciones y mostrar una página de error personalizada.

En el caso de que se produzca una excepción `TemplateInputException`, se agrega la lógica necesaria para manejarla, como la adición de atributos al modelo para mostrar un mensaje específico de error relacionado con la carga de la plantilla.

En cualquier otra excepción no controlada, se proporciona una respuesta genérica con un mensaje descriptivo del error.

Estas clases y su manejo de errores forman parte de la arquitectura de la aplicación Spring Boot, siguiendo los principios de Inversión de Control (IoC) y el Principio de Abstracción. Además, se utiliza la anotación `@ControllerAdvice` para centralizar el manejo de excepciones y lograr un código más limpio y mantenible.


### La Limitación de CustomExceptionHandler para Manejar Excepciones de Thymeleaf


La clase `CustomExceptionHandler` proporciona un mecanismo para manejar excepciones personalizadas en la aplicación y ofrecer una respuesta adecuada. Sin embargo, presenta una limitación en el manejo de excepciones específicas de Thymeleaf, como la `TemplateInputException`. A continuación, se explica por qué `CustomExceptionHandler` no puede manejar directamente estas excepciones:

En el caso de las excepciones de Thymeleaf, como la `TemplateInputException`, estas se lanzan durante la etapa de procesamiento de plantillas y son capturadas internamente por el motor de Thymeleaf. Esto significa que no se propagan directamente a la capa de manejo de excepciones de Spring.

Debido a esta limitación, `CustomExceptionHandler` no puede capturar y manejar directamente las excepciones específicas de Thymeleaf. En su lugar, se utiliza el `ErrorController` para abordar estas excepciones y proporcionar una respuesta personalizada.

Al implementar el `ErrorController`, se tiene acceso directo a la excepción lanzada y se puede verificar si es una `ServletException` con una causa de `TemplateInputException`. En caso afirmativo, se puede agregar la lógica necesaria para manejar específicamente esta excepción, como agregar atributos al modelo para mostrar un mensaje descriptivo relacionado con la carga de la plantilla.

En resumen, la necesidad de tener un `ErrorController` para manejar las excepciones de Thymeleaf radica en la forma en que estas excepciones son lanzadas y capturadas internamente por el motor de Thymeleaf. El `ErrorController` brinda la capacidad de interceptar estas excepciones y proporcionar una respuesta personalizada en caso de errores relacionados con Thymeleaf.

Esta consideración forma parte de la arquitectura de la aplicación Spring Boot, siguiendo los principios de Inversión de Control (IoC) y el Principio de Abstracción. Al utilizar el `ErrorController` junto con `CustomExceptionHandler`, se logra un manejo completo y consistente de excepciones en la aplicación.


### Manejo de Excepciones de Thymeleaf con ErrorController


En la aplicación, se utiliza la clase `ErrorController` para manejar las excepciones relacionadas con Thymeleaf y mostrar una página de error personalizada. A continuación, se explica la necesidad de tener un `ErrorController` y cómo se implementa en la aplicación:

La clase `ErrorController` implementa la interfaz `ErrorController` de Spring Boot, lo que le permite manejar los errores generados durante la ejecución de la aplicación. Esto es especialmente útil para capturar y manejar las excepciones relacionadas con Thymeleaf, como la `TemplateInputException`, que ocurre cuando hay un error en la carga de una plantilla.

El método `handleError` se encarga de procesar estas excepciones y mostrar una página de error personalizada. A través del parámetro `request` de tipo `HttpServletRequest`, se obtiene la información relacionada con el error, como la excepción lanzada. Luego, se verifica si la excepción es una `ServletException` con una causa de `TemplateInputException`. En ese caso, se agrega la lógica necesaria para manejar la excepción de Thymeleaf, como la adición de atributos al modelo para mostrar un mensaje específico de error relacionado con la carga de la plantilla.

Si la excepción no es una `TemplateInputException`, se proporciona una respuesta genérica con un mensaje descriptivo del error. Esto permite manejar otras excepciones no controladas de Thymeleaf de manera adecuada.

La implementación del `ErrorController` en la aplicación garantiza que todas las excepciones relacionadas con Thymeleaf sean capturadas y manejadas de manera consistente. Además, al mostrar una página de error personalizada, se mejora la experiencia del usuario y se proporciona información útil sobre el error ocurrido.

Esta funcionalidad forma parte de la arquitectura de la aplicación Spring Boot, siguiendo los principios de Inversión de Control (IoC) y el Principio de Abstracción. Además, se utiliza la interfaz `ErrorController` para centralizar el manejo de excepciones relacionadas con Thymeleaf y lograr un código más limpio y mantenible.

# Implementación de seguridad en el proyecto con Spring Security

En este proyecto, hemos implementado la seguridad utilizando Spring Security para proteger nuestros recursos y controlar el acceso de los usuarios. A continuación, se proporciona una explicación detallada del procedimiento y las clases involucradas en la implementación de la seguridad.

## Configuración de seguridad

La clase principal encargada de la configuración de seguridad es `MySecurityConfig`. Esta clase es anotada con `@Configuration` y `@EnableWebSecurity`, lo que indica que es una clase de configuración de Spring y habilita la funcionalidad de seguridad web de Spring Security.

La clase `MySecurityConfig` define un bean llamado `securityFilterChain`, que es un objeto de tipo `SecurityFilterChain`. Este bean se utiliza para configurar el comportamiento de Spring Security y definir las reglas de autorización para las solicitudes entrantes. Se utiliza el objeto `HttpSecurity` para configurar la cadena de filtros de autorización.

Dentro del método `securityFilterChain`, se definen las reglas de autorización utilizando el método `authorizeHttpRequests` del objeto `HttpSecurity`. Aquí se establecen las siguientes reglas:

- Se permite el acceso a la raíz del sitio y a la página de inicio (`"/", ""`) para todos (`permitAll()`).
- Se permite el acceso a los recursos estáticos de webjars (`"/webjars/**"`) para todos (`permitAll()`).
- Se permite el acceso a las páginas de error (`"/error/**"`) para todos (`permitAll()`).
- Se requiere autenticación para cualquier otra solicitud (`anyRequest().authenticated()`).

También se configura la página de inicio de sesión personalizada utilizando el método `formLogin` del objeto `HttpSecurity`. Se especifica la página de inicio de sesión (`"/login"`), la URL donde se procesará automáticamente la solicitud de inicio de sesión (`"/login"`), la URL por defecto después de un inicio de sesión exitoso (`"/"`) y se permite el acceso a todos (`permitAll()`).

Además, se configura el sistema de cierre de sesión de la aplicación utilizando el método `logout` del objeto `HttpSecurity`. Aquí se permite el acceso a todos (`permitAll()`).

En el método `securityFilterChainLocal`, se define otro bean de `SecurityFilterChain` específico para el perfil "local". Aquí se desactiva temporalmente la protección CSRF y las opciones de marco (`frameOptions`) para permitir el acceso a la consola de H2 (`/h2-console`) en entornos locales. Se configura una regla para permitir el acceso a la consola de H2.

## Clase de detalles del usuario

La clase `MyUserDetails` implementa la interfaz `UserDetails` de Spring Security y proporciona los detalles del usuario necesarios para la autenticación y autorización. Esta clase contiene campos para el nombre de usuario, contraseña y otros atributos del usuario.

Implementa los métodos de la interfaz `UserDetails`, como `getAuthorities`, `getPassword`, `getUsername`, etc., para proporcionar la información requerida por Spring Security. También se definen métodos setter y getter para los campos adicionales del usuario de nuestra aplicación.

## Servicio de detalles del usuario

La clase `MyUserDetailsService` implementa la interfaz `UserDetailsService` de Spring Security y se utiliza para cargar los detalles del usuario desde la base de datos. Esta clase se encarga de buscar y obtener los detalles del usuario de la base de datos y crear un objeto `MyUserDetails` personalizado con esos detalles.

En el método `loadUserByUsername`, se recibe el nombre de usuario como parámetro y se utiliza el repositorio de usuarios (`UsuarioRepository`) para buscar el usuario correspondiente en la base de datos. Si se encuentra el usuario, se asignan los detalles del usuario a un objeto `MyUserDetails` y se devuelven. Los detalles incluyen el nombre de usuario, la contraseña, los roles y otros atributos del usuario.

Además, se definen métodos privados dentro de `MyUserDetailsService` para obtener los roles y permisos del usuario. Estos métodos se utilizan para construir la lista de autoridades (`GrantedAuthority`) que se asigna al objeto `MyUserDetails`.

## Codificación de contraseñas

La clase `MySecurityConfig` define un bean llamado `passwordEncoder`, que utiliza `BCryptPasswordEncoder` para codificar las contraseñas de los usuarios. Este bean se utiliza para codificar y verificar las contraseñas almacenadas en la base de datos. Se recomienda utilizar un algoritmo de codificación seguro como bcrypt para almacenar las contraseñas de manera segura.

## Conclusiones

En resumen, para implementar la seguridad en nuestro proyecto con Spring Security, hemos configurado la clase `MySecurityConfig` para definir las reglas de autorización y la página de inicio de sesión personalizada. La clase `MyUserDetails` proporciona los detalles del usuario necesario para la autenticación y autorización, mientras que `MyUserDetailsService` se encarga de cargar los detalles del usuario desde la base de datos.

Además, hemos utilizado `BCryptPasswordEncoder` para codificar las contraseñas de los usuarios y garantizar la seguridad de las mismas.

Esta implementación nos permite proteger nuestros recursos, controlar el acceso de los usuarios y gestionar la autenticación y autorización en nuestro proyecto utilizando Spring Security.



## Integración de Thymeleaf con Spring Security

La integración de Thymeleaf con Spring Security permite personalizar la interfaz de usuario de acuerdo con el estado de autenticación y los roles de los usuarios. Thymeleaf proporciona el dialecto de seguridad de Spring, que incluye atributos y etiquetas especiales para mostrar u ocultar contenido basado en la autorización y la autenticación del usuario.

En los archivos HTML proporcionados, se utilizan diferentes elementos de Thymeleaf y el dialecto de seguridad para lograr esta personalización.

### Objetos #authorization y #authorization.principal

En la integración de Thymeleaf con Spring Security, los objetos `#authorization` y `#principal` tienen una relación con la interfaz `Authentication` de Spring Security.

La interfaz `Authentication` cumple dos propósitos principales dentro de Spring Security:

1. Proporciona las credenciales que un usuario ha proporcionado para la autenticación, como entrada al `AuthenticationManager`. En este escenario, `isAuthenticated()` devuelve `false`.

2. Representa al usuario actualmente autenticado. Puedes obtener la instancia actual de `Authentication` desde el `SecurityContext`.

La interfaz `Authentication` contiene las siguientes propiedades:

- `principal`: Identifica al usuario. Es una instancia de `UserDetails`.

- `credentials`: A menudo, una contraseña. En muchos casos, esta propiedad se borra después de que el usuario se autentica, para asegurarse de que no se filtre.

- `authorities`: Las instancias de `GrantedAuthority` representan permisos de alto nivel otorgados al usuario. En nuestra aplicación son los roles y los permisos.

En resumen, el objeto `#authorization` se utiliza para evaluar expresiones de autorización en las plantillas HTML, y el objeto `#authorization.principal` proporciona acceso a los detalles del usuario autenticado, como el `UserDetails`. Ambos objetos están relacionados con la interfaz `Authentication` de Spring Security, que se utiliza para proporcionar credenciales y representar al usuario autenticado.



### Index

En el archivo `index.html`, se utiliza el atributo `sec:authorize` junto con la expresión `isAuthenticated()` en la etiqueta `<h1>` para mostrar el saludo "Hello [nombre]" solo si el usuario está autenticado. La expresión `${#authentication.principal.nombre}` se utiliza para obtener el nombre del usuario autenticado y mostrarlo dinámicamente.

Además, se utilizan las etiquetas `<div>` con las clases `alert alert-success`, `alert alert-primary` y `d-flex` junto con el atributo `sec:authorize` y las expresiones `hasAuthority('ROLE_ADMIN')` y `hasAuthority('ROLE_USUARIO')` para mostrar contenido específico basado en los roles del usuario autenticado. Estas etiquetas muestran mensajes e iconos diferentes según el rol del usuario.

El formulario `<form>` con el atributo `sec:authorize="isAuthenticated()"` y la etiqueta `<input>` dentro del mismo se muestran solo si el usuario está autenticado. Este formulario se utiliza para realizar la acción de cierre de sesión con `th:action="@{/logout}"`.

### Modal

En el archivo `modal.html`, se utiliza la etiqueta `<img>` con el atributo `th:src="${#authentication.principal.imageUrl}"` para mostrar la imagen de perfil del usuario autenticado. La expresión `${#authentication.principal.imageUrl}` se utiliza para obtener la URL de la imagen de perfil desde el objeto principal del usuario autenticado.

Además, se utiliza la etiqueta `<span>` con la expresión `th:text="${#authentication.principal.username}"` para mostrar el nombre de usuario del usuario autenticado.

El fragmento `fragments/permisos` se incluye utilizando la etiqueta `<div th:replace="fragments/permisos :: permisos">` para mostrar los permisos del usuario autenticado. Este fragmento utiliza la etiqueta `<span>` con la expresión `th:each="permiso : ${#authentication.principal.getAuthorities()}"` para iterar sobre la lista de permisos y mostrarlos en forma de insignias.

### Fragmento de Permisos

En el archivo `permisos.html`, se utiliza el atributo `sec:authorize` junto con la expresión `isAuthenticated()` en la etiqueta `<div>` para mostrar el título "Estos son tus permisos" solo si el usuario está autenticado.

La etiqueta `<span>` con la expresión `th:each="permiso : ${#authentication.principal.getAuthorities()}"` se utiliza para iterar sobre la lista de permisos del usuario autenticado y mostrar cada permiso en forma de insignia.

En resumen, la integración de Thymeleaf con Spring Security en los archivos HTML proporcionados se realiza utilizando atributos y


## Logging con Log4j2 y Lombok

Log4j2 es un framework de registro (logging) ampliamente utilizado en aplicaciones Java para capturar y administrar los mensajes de registro. Lombok es una biblioteca que simplifica el desarrollo de Java al reducir la necesidad de escribir código repetitivo, como los métodos getter/setter o constructores. Al combinar Log4j2 y Lombok, puedes lograr configuraciones de logging más concisas y legibles.

Para utilizar Log4j2 con Lombok en tu aplicación Spring Boot, hemos seguido estos pasos:



### Control de Niveles de Log en Spring Boot, Hibernate y JPA

En una aplicación Spring Boot que utiliza Hibernate y JPA, es posible controlar los niveles de log de cada componente mediante la configuración de archivos `.properties`. Aquí se explica cómo:

1. Crea un archivo de configuración `.properties` (por ejemplo, `application.properties`) si aún no lo tienes en tu proyecto.

2. Para controlar los niveles de log de Spring Boot, agrega las siguientes propiedades en el archivo `.properties` y establece el nivel de log deseado (puedes elegir uno de los niveles `TRACE`, `DEBUG`, `INFO`, `WARN`, `ERROR`):

```
# Nivel de log de Spring Boot
logging.level.root=INFO
logging.level.org.springframework=INFO
```

3. Para controlar los niveles de log de Hibernate y JPA, agrega las siguientes propiedades en el archivo `.properties` y establece el nivel de log deseado:

```
Nivel de log de Hibernate y JPA
logging.level.org.hibernate=INFO
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql=TRACE
```


Estas propiedades permiten controlar los niveles de log para los componentes de Spring Boot, Hibernate y JPA. Puedes ajustar los niveles según tus necesidades y preferencias.

Recuerda que los niveles de log más comunes son `TRACE`, `DEBUG`, `INFO`, `WARN` y `ERROR`, y cada nivel muestra mensajes de log con mayor o menor detalle. Asegúrate de establecer los niveles de log de acuerdo con tus requisitos de depuración y registro de la aplicación.

Con esta configuración, tendrás un mayor control sobre los niveles de log de Spring Boot, Hibernate y JPA en tu aplicación. A medida que ajustes los niveles, podrás ver los mensajes de log relevantes en la consola o en el archivo de registro correspondiente.

¡No olvides reiniciar la aplicación después de realizar cambios en la configuración de log!


### Control del nivel de log de nuestra aplicación

Además, puedes controlar los niveles de log de otros componentes de Spring Boot siguiendo un patrón similar. Por ejemplo, si deseas controlar el nivel de log de una clase específica, puedes utilizar la siguiente configuración:

```
logging.level.com.eoi.ejemplospringboot.Miclase = DEBUG
```

Esto establecerá el nivel de log DEBUG para la clase logging.level.com.eoi.ejemplospringboot.Miclase. Puedes agregar múltiples líneas para configurar diferentes paquetes o clases según sea necesario.

```
logging.level.com.eoi.ejemplospringboot.controllers = INFO
```

Recuerda que la configuración del nivel de log se aplica a los paquetes o clases específicas que se definen. Otros paquetes o clases seguirán utilizando el nivel de log predeterminado o el nivel de log definido para su paquete padre.



# Thymeleaf

Thymeleaf es un motor de plantillas para Java que se utiliza principalmente en aplicaciones web. Permite generar contenido dinámico en el servidor y renderizarlo en el lado del cliente. El objetivo principal de Thymeleaf es combinar el HTML con datos provenientes del servidor para producir una salida final que se pueda mostrar en un navegador web.

## Funcionamiento general

1. **Creación de plantillas HTML**
   
   Debes crear tus plantillas HTML utilizando la sintaxis de Thymeleaf. Estas plantillas pueden contener tanto código HTML estático como código Thymeleaf dinámico. El código Thymeleaf se escribe utilizando atributos especiales en las etiquetas HTML.

2. **Procesamiento de plantillas en el servidor**

   Cuando un cliente solicita una página, el servidor procesa la plantilla HTML con Thymeleaf. Durante este proceso, Thymeleaf evalúa y procesa los atributos especiales y los datos provenientes del servidor, generando así una versión final del HTML.

3. **Envío de HTML generado al cliente**

   Una vez que la plantilla se ha procesado, el servidor envía el HTML generado al cliente, que puede ser un navegador web. El cliente recibe el HTML y lo muestra en el navegador, con todos los datos y elementos dinámicos correctamente renderizados.

## Sistema de Expresiones Estándar de Thymeleaf

Thymeleaf utiliza un sistema de expresiones estándar (Standard Expression Language, o simplemente, Thymeleaf Expression Language) para evaluar y manipular datos en las plantillas. Estas expresiones se utilizan para acceder a objetos y variables en el contexto del servidor y realizar operaciones dinámicas dentro de las plantillas.

### Sintaxis de las Expresiones

Thymeleaf ofrece diferentes tipos de expresiones con distintas sintaxis. A continuación, se describen los cuatro tipos más comunes:

- **Variable Expressions**: Se escriben utilizando `${...}` y se utilizan para acceder a variables y propiedades del contexto del servidor. Por ejemplo, `${mensaje}` accede a la variable `mensaje`.

- **Selection Variable Expressions**: Se escriben utilizando `*{...}` y se utilizan para acceder a variables y propiedades del contexto del servidor en el contexto de selección. Estas expresiones se utilizan generalmente dentro de atributos HTML para establecer valores. Por ejemplo, `*{usuario.nombre}` accede a la propiedad `nombre` del objeto `usuario`.

- **Message Expressions**: Se escriben utilizando `#{...}` y se utilizan para acceder a mensajes internacionales en archivos de mensajes. Estas expresiones son útiles para la internacionalización de aplicaciones. Por ejemplo, `#{saludo.bienvenida}` accede al mensaje con la clave `saludo.bienvenida`.

- **Link URL Expressions**: Se escriben utilizando `@{...}` y se utilizan para generar URLs de enlaces. Estas expresiones permiten construir URLs dinámicas en función de los datos del servidor. Por ejemplo, `@{/usuarios/${id}}` genera una URL para acceder al recurso de un usuario con un ID específico.

### Funcionalidades de las Expresiones

Además de las distintas sintaxis, las expresiones de Thymeleaf ofrecen una variedad de funcionalidades para manipular datos en las plantillas. Algunas de las funcionalidades más comunes son:

- Acceso a propiedades: Puedes acceder a propiedades de objetos utilizando la notación de punto, como `${usuario.nombre}` para acceder a la propiedad `nombre` del objeto `usuario`.

- Evaluación condicional: Puedes utilizar expresiones condicionales para mostrar u ocultar contenido en función de ciertas condiciones. Por ejemplo, `th:if="${usuario != null}"` muestra el contenido solo si la variable `usuario` no es nula.

- Iteración: Puedes iterar sobre colecciones utilizando expresiones como `th:each` para generar contenido repetitivo para cada elemento.

- Operaciones aritméticas y lógicas: Puedes realizar operaciones aritméticas y lógicas utilizando expresiones, como `${num1 + num2}` para sumar dos variables.

Estas son solo algunas de las funcionalidades que puedes utilizar con las expresiones de Thymeleaf. La expresión completa es poderosa y flexible, lo que te permite realizar operaciones complejas dentro de tus plantillas.

Si tienes más preguntas, no dudes en hacerlas.


### Objetos Disponibles en las Expresiones

Thymeleaf proporciona varios objetos predefinidos que se pueden utilizar en las expresiones para acceder a diferentes partes del contexto del servidor. Aquí hay algunos objetos comunes:

- `#ctx`: Proporciona acceso al contexto de ejecución actual.
- `#vars`: Proporciona acceso a todas las variables disponibles en el contexto.
- `#locale`: Proporciona acceso a la configuración regional actual.
- `#httpServletRequest`: Proporciona acceso al objeto HttpServletRequest.
- `#httpSession`: Proporciona acceso al objeto HttpSession.

Además de estos objetos predefinidos, también puedes acceder a los objetos y variables definidos en el contexto del servidor, como modelos, atributos de solicitud y atributos de sesión.


## Funcionalidades de las Expresiones

Las expresiones de Thymeleaf ofrecen además una variedad de funcionalidades para manipular datos en las plantillas. 

Aquí hay algunas funcionalidades comunes:

- Acceso a propiedades: Puedes acceder a propiedades de objetos utilizando la notación de punto, como `${usuario.nombre}` para acceder a la propiedad `nombre` del objeto `usuario`.

- Evaluación condicional: Puedes utilizar expresiones condicionales para mostrar u ocultar contenido en función de ciertas condiciones. Por ejemplo, `th:if="${usuario != null}"` muestra el contenido solo si la variable `usuario` no es nula.

- Iteración: Puedes iterar sobre colecciones utilizando expresiones como `th:each` para generar contenido repetitivo para cada elemento.

- Operaciones aritméticas y lógicas: Puedes realizar operaciones aritméticas y lógicas utilizando expresiones, como `${num1 + num2}` para sumar dos variables.

Estas son solo algunas de las funcionalidades que puedes utilizar con las expresiones de Thymeleaf. La expresión completa es poderosa y flexible, lo que te permite realizar operaciones complejas dentro de tus plantillas.

Si tienes más preguntas, no dudes en hacerlas.



## Atributos de Thymeleaf

Thymeleaf utiliza varios atributos especiales que se pueden aplicar a las etiquetas HTML para lograr funcionalidades específicas. Aquí hay algunos atributos principales utilizados en Thymeleaf:

- **th:text**: Este atributo se utiliza para establecer el contenido de texto de una etiqueta. Permite mostrar valores de variables o expresiones del servidor dentro de las etiquetas.

- **th:if**: Permite realizar una evaluación condicional en el lado del servidor y mostrar u ocultar contenido HTML en función del resultado.

- **th:each**: Este atributo se utiliza para iterar sobre una colección de elementos en el servidor y generar contenido HTML repetitivo para cada elemento.

- **th:href**: Se utiliza para establecer el valor del atributo `href` de una etiqueta `<a>` o `link`. Permite generar enlaces dinámicos en función de los datos del servidor.

- **th:submit**: Se aplica a los botones de envío `<input>` o `<button>` y define la acción a realizar cuando se envía un formulario.

- **th:src**: Se utiliza para establecer el valor del atributo `src` de una etiqueta `<img>` o `<script>`. Permite cargar imágenes o scripts dinámicamente en función de los datos del servidor.

- **th:class**: Permite establecer las clases CSS de una etiqueta HTML de manera dinámica.

- **th:style**: Se utiliza para establecer los estilos CSS de una etiqueta HTML.

- **th:attr**: Permite establecer atributos HTML personalizados o atributos especiales.

- **th:switch**: Permite realizar evaluaciones condicionales más complejas utilizando múltiples casos y un valor de comparación.

- **th:case**: Se utiliza dentro de un bloque `th:switch` para definir un caso específico que se evaluará y mostrará si coincide con el valor de comparación.

- **th:unless**: Realiza una evaluación condicional negativa. El contenido dentro de este atributo se mostrará solo si la expresión es falsa.

- **th:include**: Se utiliza para incluir una plantilla externa dentro de otra plantilla. Esto es útil para reutilizar fragmentos de código en diferentes partes de una aplicación.

Estos son solo algunos ejemplos de atributos utilizados en Thymeleaf

### Ejemplos: 

```html

<!-- Ejemplo de atributo th:text -->
<p th:text="${mensaje}">Texto predeterminado</p>

<!-- Ejemplo de atributo th:if -->
<div th:if="${usuario != null}">
    <p>Bienvenido, <span th:text="${usuario.nombre}"></span>!</p>
</div>

<!-- Ejemplo de atributo th:each -->
<ul>
    <li th:each="producto : ${productos}" th:text="${producto.nombre}"></li>
</ul>

<!-- Ejemplo de atributo th:href -->
<a th:href="@{/productos/${productoId}}">Ver detalles del producto</a>

<!-- Ejemplo de atributo th:src -->
<img th:src="@{/img/${imagen}}" alt="Imagen de producto">

<!-- Ejemplo de atributo th:class -->
<div th:class="${activo} ? 'activo' : 'inactivo'">Estado</div>

<!-- Ejemplo de atributo th:style -->
<div th:style="'background-color:' + ${color}">Fondo</div>

<!-- Ejemplo de atributo th:attr -->
<input type="text" th:attr="readonly=${deshabilitado}" />

<!-- Ejemplo de atributo th:switch y th:case -->
<div th:switch="${diaDeLaSemana}">
    <p th:case="'Lunes'">Es el primer día de la semana.</p>
    <p th:case="'Martes'">Es el segundo día de la semana.</p>
    <p th:case="'Miércoles'">Es el tercer día de la semana.</p>
    <p th:case="'Jueves'">Es el cuarto día de la semana.</p>
    <p th:case="'Viernes'">Es el quinto día de la semana.</p>
    <p th:case="*">Es otro día de la semana.</p>
</div>

```



## Fragmentos en Thymeleaf

Los fragmentos en Thymeleaf permiten reutilizar y modularizar el código HTML en diferentes partes de una aplicación. Los fragmentos son secciones de plantillas HTML que se pueden extraer y utilizar en varias plantillas, lo que facilita la creación y mantenimiento de código limpio y modular.

### Creación de fragmentos

Para crear un fragmento en Thymeleaf, simplemente define una sección del código HTML en una plantilla y luego extrae esa sección en un archivo independiente. Por lo general, los fragmentos se guardan en archivos con extensión `.html` y se almacenan en un directorio común para facilitar su reutilización.

```html
<!-- En la plantilla principal -->
<html>
  <head>
    <!-- ... -->
  </head>
  <body>
    <div th:include="fragments/header"></div>
    <!-- ... -->
    <div th:include="fragments/footer"></div>
  </body>
</html>

```
```html
<!-- En fragments/header.html -->
<header>
  <!-- Código HTML del encabezado -->
</header>
```

```html
<!-- En fragments/footer.html -->
<footer>
  <!-- Código HTML del pie de página -->
</footer>
```


### Inclusión de fragmentos
Una vez que has creado tus fragmentos, puedes incluirlos en otras plantillas utilizando el atributo th:include o th:replace. Ambos atributos te permiten especificar la ruta del fragmento a incluir. La diferencia es que th:include incluye el fragmento como parte del contenido de la etiqueta, mientras que th:replace reemplaza completamente la etiqueta por el contenido del fragmento.

```html
<!-- Ejemplo de inclusión de fragmentos -->
<div th:include="fragments/header"></div>
<div th:replace="fragments/footer"></div>
```

### Pasando datos a los fragmentos

Los fragmentos también pueden recibir datos dinámicos desde la plantilla principal o desde otras secciones de código. Esto se logra utilizando el atributo th:with para establecer variables que se utilizarán dentro del fragmento.

```html
<!-- Pasando datos a un fragmento -->
<div th:include="fragments/header" th:with="titulo='Mi Página'"></div>
```

```html
<!-- En fragments/header.html -->
<header>
  <h1 th:text="${titulo}"></h1>
</header>
```

### Ventajas de usar fragmentos

El uso de fragmentos en Thymeleaf tiene varias ventajas:

- **Reutilización de código**: Los fragmentos permiten encapsular y reutilizar partes del código HTML en diferentes plantillas, evitando la duplicación y mejorando la mantenibilidad.

- **Modularidad**: Los fragmentos facilitan la construcción de una estructura modular en la cual los componentes se pueden actualizar y modificar de forma independiente.

- **Separación de preocupaciones**: Los fragmentos permiten separar el código HTML en partes lógicas y centrarse en aspectos específicos de una página web, como el encabezado, el pie de página o la navegación.

Utilizando fragmentos, puedes construir plantillas HTML más flexibles y escalables en tus aplicaciones Thymeleaf.



# Repository Query Methods en JPA Spring Hibernate

Los Repository Query Methods son una característica proporcionada por Spring Hibernate para facilitar la creación de consultas a la base de datos utilizando métodos de los repositorios. Estos métodos permiten definir consultas de forma declarativa y concisa, sin la necesidad de escribir consultas SQL completas.

## Lenguaje y estructura de los Repository Query Methods

Los Repository Query Methods utilizan un lenguaje de consulta basado en los nombres de los métodos del repositorio. La estructura de un Repository Query Method se compone de tres partes principales:

1. **Prefijo del método:** El prefijo del método describe la operación que se realizará en la base de datos. Algunos ejemplos comunes de prefijos son:
    - `findBy`: recupera una lista de entidades que coinciden con los criterios de búsqueda.
    - `getBy`: recupera una única entidad que coincide con los criterios de búsqueda.
    - `countBy`: cuenta el número de entidades que coinciden con los criterios de búsqueda.

2. **Propiedades y condiciones:** Después del prefijo del método, se especifican las propiedades de la entidad y las condiciones de búsqueda. Esto se hace utilizando una sintaxis que combina el nombre de la propiedad de la entidad y un operador condicional. Por ejemplo, `findByFirstName(String firstName)` buscará entidades que tengan el campo `firstName` igual al valor proporcionado.

3. **Retorno de datos:** La firma del método también indica el tipo de datos que se devolverá. Puede ser una lista de entidades, una entidad única, un número entero (para operaciones de conteo) u otros tipos de datos según sea necesario.

### Prefijos del método

| Prefijo del Método | Retorno de Datos                |
|--------------------|---------------------------------|
| `findBy`           | Lista de entidades              |
| `getBy`            | Entidad única                   |
| `readBy`           | Lista de entidades              |
| `queryBy`          | Lista de entidades              |
| `streamBy`         | Stream de entidades             |
| `countBy`          | Número entero                    |
| `deleteBy`         | Número entero (afectados)        |
| `removeBy`         | Número entero (afectados)        |
| `existsBy`         | Valor booleano                   |
| `findFirstBy`      | Entidad única                   |
| `findTopBy`        | Entidad única                   |
| `findDistinctBy`   | Lista de entidades sin duplicados|
| `findWith`         | Lista de entidades              |
| `countDistinctBy`  | Número entero sin duplicados     |


### Condiciones y ordenación

| Propiedad/Condición          | Descripción                                                                                     |
|-----------------------------|-------------------------------------------------------------------------------------------------|
| `Equals` / `Is`             | Igualdad                                                                                        |
| `Not` / `IsNot`             | Desigualdad                                                                                     |
| `IsNull`                    | Nulo                                                                                            |
| `IsNotNull`                 | No nulo                                                                                         |
| `Like`                      | Coincidencia de patrón (puede incluir `%` como comodín)                                         |
| `NotLike`                   | No coincide con el patrón especificado                                                          |
| `StartingWith` / `StartsWith` | Comienza con el valor especificado                                                             |
| `EndingWith` / `EndsWith`     | Termina con el valor especificado                                                               |
| `Containing` / `Contains`     | Contiene el valor especificado                                                                  |
| `OrderBy`                   | Ordenar resultados en orden ascendente por una propiedad específica                               |
| `OrderBy...Desc`            | Ordenar resultados en orden descendente por una propiedad específica                             |
| `IgnoreCase`                | Ignorar distinción entre mayúsculas y minúsculas                                                |
| `Between`                   | En un rango de valores específico                                                               |
| `GreaterThan` / `After`      | Mayor que un valor específico                                                                   |
| `LessThan` / `Before`         | Menor que un valor específico                                                                   |
| `GreaterThanEqual` / `AfterOrEqual` | Mayor o igual que un valor específico                                                    |
| `LessThanEqual` / `BeforeOrEqual`   | Menor o igual que un valor específico                                                    |
| `In`                        | Coincide con uno de los valores en una lista                                                     |
| `NotIn`                     | No coincide con ninguno de los valores en una lista                                              |
| `True`                      | Verdadero                                                                                       |
| `False`                     | Falso                                                                                           |


### Posibles valores de retorno de los métodos

| Opción de Retorno de Datos   | Descripción                                                                                            |
|-----------------------------|--------------------------------------------------------------------------------------------------------|
| `List`                      | Devuelve una lista de entidades que coinciden con la consulta                                          |
| `Set`                       | Devuelve un conjunto de entidades que coinciden con la consulta                                        |
| `Collection`                | Devuelve una colección de entidades que coinciden con la consulta                                      |
| `Iterable`                  | Devuelve un iterador de entidades que coinciden con la consulta                                        |
| `Stream`                    | Devuelve un stream de entidades que coinciden con la consulta                                          |
| `Optional`                  | Devuelve un objeto Optional que contiene una entidad o es vacío                                        |
| `Page`                      | Devuelve una página de resultados para admitir paginación                                              |
| `Slice`                     | Devuelve una rebanada de resultados para admitir paginación sin necesidad de contar total de elementos |
| `Streamable`                | Devuelve un objeto Streamable que permite trabajar con el resultado de forma más flexible              |
| `Entity`                    | Devuelve una única entidad que coincide con la consulta                                                |
| `Entity[]`                  | Devuelve un array de entidades que coinciden con la consulta                                           |
| `Object`                    | Devuelve un objeto genérico que puede contener cualquier tipo de datos                                 |
| `Integer` / `Long` / `Double` / ...    | Devuelve un valor numérico que representa la cantidad de entidades que coinciden con la consulta       |


### Ejemplos de Query Methods


Aquí tienes algunos ejemplos de cómo se pueden utilizar los Repository Query Methods:


| Método de la Interfaz                                               | Descripción                                                                                             |
|--------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| `List<Entity> findByUsername(String username);`                     | Busca una lista de entidades por nombre de usuario                                                       |
| `List<Entity> findByAgeGreaterThan(int age);`                       | Busca una lista de entidades por edad mayor que un valor específico                                     |
| `Optional<Entity> findByEmail(String email);`                       | Busca una entidad única por dirección de correo electrónico                                              |
| `Entity findFirstByOrderByIdDesc();`                                | Busca la primera entidad ordenada por ID de forma descendente                                            |
| `List<Entity> findByLastNameLike(String pattern);`                  | Busca una lista de entidades por apellido que coincida con un patrón específico                        |
| `List<Entity> findByActiveTrueAndRoleIn(List<Role> roles);`         | Busca una lista de entidades activas y con roles específicos                                            |
| `List<Entity> findByCreationDateBetween(Date startDate, Date endDate);` | Busca una lista de entidades por fecha de creación dentro de un rango específico                      |
| `int countByStatusAndArchivedFalse(String status);`                  | Cuenta el número de entidades con un estado específico y que no estén archivadas                        |
| `void deleteByExpiredTrue();`                                       | Elimina las entidades expiradas                                                                         |
| `Page<Entity> findByCategoryIdOrderByCreationDateDesc(Long categoryId, Pageable pageable);` | Busca una página de entidades por categoría de ID y las ordena por fecha de creación descendente  |



## Paginación y Ordenación con JpaRepository

Cuando trabajamos con grandes conjuntos de datos en una aplicación, es común que los resultados de una consulta sean demasiado extensos para mostrarlos todos en una sola página. En estos casos, la paginación y la ordenación se convierten en soluciones eficientes y escalables.

### Paginación

La paginación permite dividir los resultados de una consulta en pequeñas porciones llamadas "páginas". Cada página contiene un número limitado de elementos, lo que facilita su visualización y mejora el rendimiento de la aplicación al reducir la carga de datos transferidos.

JpaRepository en Spring proporciona soporte integrado para la paginación de resultados. Utiliza la interfaz `Pageable` para especificar los parámetros de paginación, como el número de página y el tamaño de la página.

### Objeto Pageable y Paginación en Spring Data JPA

En Spring Data JPA, el objeto `Pageable` se utiliza para configurar y controlar la paginación en consultas a través de repositorios. Proporciona métodos y atributos que permiten definir el tamaño de página, el número de página y la ordenación de los resultados.

### Componentes del objeto Pageable

El objeto `Pageable` consta de tres componentes principales:

1. **Tamaño de página**: Define el número de elementos que se mostrarán en cada página. Especifica cuántos registros se devolverán en cada consulta. Se puede configurar utilizando el método `pageSize` o a través del constructor de `PageRequest`.

2. **Número de página**: Representa el número de página que se desea recuperar. El índice de página comienza desde cero. Por ejemplo, la primera página se representa con el número 0, la segunda con el número 1, y así sucesivamente. Se puede configurar utilizando el método `pageNumber` o a través del constructor de `PageRequest`.

3. **Ordenación**: Permite especificar el orden en el que se deben devolver los resultados. Puede ordenarse por uno o varios campos y en orden ascendente o descendente. Se puede configurar utilizando el método `sort` o a través del constructor de `PageRequest`.

### Utilizando Pageable en los repositorios

La habilitación de la paginación en JpaRepository es posible gracias a que JpaRepository a su vez extiende la interfaz [PagingAndSortingRepository](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/PagingAndSortingRepository.html). Esta interfaz proporciona funcionalidades adicionales para la paginación y la ordenación de los resultados de las consultas.

PagingAndSortingRepository define métodos adicionales para realizar consultas que admiten la paginación y la ordenación de los resultados. Estos métodos incluyen findAll(Pageable pageable), findAll(Sort sort), entre otros.

Al heredar de PagingAndSortingRepository, JpaRepository hereda también estos métodos, lo que permite que los repositorios que extienden JpaRepository tengan la capacidad de realizar consultas paginadas y ordenadas sin tener que implementar manualmente la lógica de paginación y ordenación.

En resumen, al heredar de PagingAndSortingRepository, JpaRepository obtiene la funcionalidad de paginación y ordenación, lo que permite que los repositorios que extienden JpaRepository utilicen métodos predefinidos como findAll(Pageable pageable) para realizar consultas paginadas y obtener resultados de forma fácil y eficiente.

Para habilitar la paginación en un repositorio que extiende `JpaRepository`, simplemente agrega un parámetro de tipo `Pageable` en los métodos de consulta que deseas paginar. 


A continuación, se muestra un ejemplo:

```java
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Page<Producto> findAll(Pageable pageable);
}
```

En el ejemplo anterior, el método `findAll` acepta un objeto `Pageable` como parámetro y devuelve un objeto `Page` que contiene los resultados paginados.

### Creando objetos Pageable

Existen varias formas de crear objetos `Pageable`. Algunas opciones son:

1. **Utilizando `PageRequest`**: Puedes crear un objeto `Pageable` utilizando el constructor de `PageRequest`. Por ejemplo: `PageRequest.of(pageNumber, pageSize)`. Esto creará un objeto `Pageable` con el número de página y el tamaño de página especificados.

2. **Anotación `@PageableDefault`**: Puedes utilizar la anotación `@PageableDefault` en los parámetros del controlador para proporcionar valores predeterminados para la paginación en las solicitudes. Por ejemplo: `@PageableDefault(page = 0, size = 10)`.


## Utilizando objetos Page en el resultado

Cuando utilizas objetos `Pageable` en tus consultas, obtendrás un objeto `Page` como resultado. Este objeto contiene los resultados de la consulta actual, así como información adicional sobre la paginación, como el número total de páginas, el número total de elementos, etc. Puedes acceder a los resultados y a la información de paginación a través de los métodos proporcionados por el objeto `Page`.

## Ejemplo de uso de objetos Pageable

Aquí tienes un ejemplo de cómo utilizar objetos `Pageable` en un controlador de Spring MVC (de tipo REST):

```java
@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<Page<Producto>> obtenerProductosPaginados(
            @RequestParam(defaultValue = "0") int numeroPagina,
            @RequestParam(defaultValue = "10") int tamanoPagina) {
        Pageable pageable = PageRequest.of(numeroPagina, tamanoPagina);
        Page<Producto> productosPage = productoService.obtenerProductosPaginados(pageable);
        return ResponseEntity.ok(productosPage);
    }
}
```

De todos modos, en nuestra aplicación utilizamos thymeleaf, por lo que las cosas varían un poquito:

En tu controlador, asegúrate de obtener el objeto Page a partir de la consulta paginada y agregarlo al modelo:
```java
@GetMapping("/productos")
public String obtenerProductosPaginados(
        @RequestParam(defaultValue = "0") int numeroPagina,
        @RequestParam(defaultValue = "10") int tamanoPagina,
        Model model) {
    Pageable pageable = PageRequest.of(numeroPagina, tamanoPagina);
    Page<Producto> productosPage = productoService.obtenerProductosPaginados(pageable);
    model.addAttribute("productos", productosPage);
    return "productos";
}
```

En tu plantilla Thymeleaf, puedes utilizar las propiedades y métodos proporcionados por el objeto `Page` para mostrar los resultados de la paginación. Aquí tienes un ejemplo:

```html
<!-- productos.html -->
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio</th>
        </tr>
    </thead>
    <tbody>
        <tr th:each="producto : ${productos.content}">
            <td th:text="${producto.id}"></td>
            <td th:text="${producto.nombre}"></td>
            <td th:text="${producto.precio}"></td>
        </tr>
    </tbody>
</table>

<div class="pagination">
    <ul>
        <li th:class="${productos.first ? 'disabled' : ''}">
            <a th:href="@{/?numeroPagina=${productos.number - 1}}">&laquo;</a>
        </li>
        <li th:each="page : ${productos.number.sequence(productos.totalPages)}" 
            th:class="${page == productos.number ? 'active' : ''}">
            <a th:href="@{/?numeroPagina=${page}}">[[${page}]]</a>
        </li>
        <li th:class="${productos.last ? 'disabled' : ''}">
            <a th:href="@{/?numeroPagina=${productos.number + 1}}">&raquo;</a>
        </li>
    </ul>
</div>

```



# Formulario POST con Thymeleaf

Para hacer un formulario POST con Thymeleaf, necesitarás crear un formulario HTML en tu plantilla Thymeleaf y luego configurar el controlador correspondiente para recibir los datos del formulario.


Te mostraré dos ejemplos, uno utilizando `th:object` y otro sin utilizarlo.

## Ejemplo con `th:object`

1. En tu plantilla Thymeleaf, define el formulario utilizando `th:object` para enlazar los datos del formulario a un objeto cualquiera del modelo:

```html
<form th:object="${producto}" method="post" action="/guardar-producto">
    <input type="text" th:field="*{nombre}" placeholder="Nombre" />
    <input type="number" th:field="*{precio}" placeholder="Precio" />
    <button type="submit">Guardar</button>
</form>
```

En este ejemplo, `th:object="${producto}"` enlaza los datos del formulario al objeto `producto` del modelo. 

Además, `th:field="*{nombre}"` y `th:field="*{precio}"` enlazan los campos del formulario con las propiedades nombre y precio del objeto producto.


2. En tu controlador de Spring MVC, configura el método POST para recibir los datos del formulario:

```java
@Controller
public class ProductoController {
    @PostMapping("/guardar-producto")
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        // Lógica para guardar el producto en la base de datos
        productoService.guardar(producto);
        return "redirect:/productos";
    }
}

```

En el controlador, utilizamos `@PostMapping` para configurar el método para recibir las solicitudes `POST`. El parámetro `@ModelAttribute("producto")` vincula los datos del formulario al objeto `producto` en el modelo.

### Sin `th:object`

Si prefieres no utilizar th:object en tu formulario, puedes acceder a los datos del formulario directamente desde el objeto HttpServletRequest en el controlador:


```java
@Controller
public class ProductoController {
    @PostMapping("/guardar-producto")
    public String guardarProducto(HttpServletRequest request) {
        String nombre = request.getParameter("nombre");
        double precio = Double.parseDouble(request.getParameter("precio"));
        
        // Lógica para guardar el producto en la base de datos
        
        return "redirect:/productos";
    }
}
```

En el controlador, utilizamos `HttpServletRequest` para acceder a los datos del formulario directamente utilizando `request.getParameter("nombre")` y `request.getParameter("precio")`.

Recuerda ajustar los nombres de los atributos y las rutas en tu código según tus necesidades.

Además, recuerda que al estar utilizando `Spring Boot` disponemos de algunas anotaciones más que simplifican el código:

```java
@Controller
public class ProductoController {
    @PostMapping("/guardar-producto")
    public String guardarProducto(@RequestParam("nombre") String nombre, 
                                  @RequestParam("precio") double precio) {
        // Lógica para guardar el producto en la base de datos
        
        return "redirect:/productos";
    }
}
```

En este ejemplo, utilizamos `@RequestParam("nombre")` y `@RequestParam("precio")` para acceder a los valores enviados desde el formulario. Los valores se asignan directamente a las variables `nombre` y `precio` en el método `guardarProducto`.

Recuerda ajustar los nombres de los atributos y las rutas en tu código según tus necesidades.



# Cómo crear una instancia de Sonarqube con Docker - Compose

Docker compose es una funcionalidad de Docker que nos permite agrupar contenedores y desplegarlos todos en conjunto. 

Además, permite establecer comunicación y reglas entre ellos, lo que favorece la instalación de sistemas como sonarqube
, que requiere de la instalación de una base de datos externa para trabajar. 

Así, necesitamos crear un archivo `docker-compose.yml` con el siguiente contenido:


```yml
version: "3"
services:
  sonarqube:
    image: sonarqube:community
    hostname: sonarqube
    container_name: sonarqube
    depends_on:
      - db
    environment:
      SONAR_JDBC_URL: jdbc:postgresql://db:5432/sonar
      SONAR_JDBC_USERNAME: sonar
      SONAR_JDBC_PASSWORD: sonar
    volumes:
      - sonarqube_data:/opt/sonarqube/data
      - sonarqube_extensions:/opt/sonarqube/extensions
      - sonarqube_logs:/opt/sonarqube/logs
    ports:
      - "0.0.0.0:80:9000"
  db:
    image: postgres:13
    hostname: postgresql
    container_name: postgresql
    environment:
      POSTGRES_USER: sonar
      POSTGRES_PASSWORD: sonar
      POSTGRES_DB: sonar
    volumes:
      - postgresql:/var/lib/postgresql
      - postgresql_data:/var/lib/postgresql/data

volumes:
  sonarqube_data:
  sonarqube_extensions:
  sonarqube_logs:
  postgresql:
  postgresql_data:
``

Esto levantará una instancia de sonarqube en el puerto 80 de nuestra máquina local.

Se recomienda cambiar a otro puerto de servicio para evitar problemas con los servicios http habituales.

También se recomienda evitar el puerto 8080 pues es el de Tomcat. 

Se puede utilizar el puerto 9000 si bien hay proveedores de internet que no permiten abrirlo.
 

