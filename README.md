# App MVC Spring Boot - CRUD Usuarios y Asignaturas

Aplicación web desarrollada con Spring Boot MVC, Thymeleaf, Spring Data JPA y MySQL.  
El proyecto implementa operaciones CRUD para dos entidades principales:

- Usuarios
- Asignaturas

La estructura del proyecto sigue una arquitectura MVC sencilla, separando responsabilidades en modelo, DAO, servicio, controlador y vistas.

## Tecnologías utilizadas

- Java 21
- Spring Boot 4.0.6
- Spring Web MVC
- Spring Data JPA
- Thymeleaf
- MySQL
- Lombok
- Spring Security
- Maven Wrapper

## Estructura general del proyecto

```txt
src/main/java/com/asignatura/app/
├── controladores/
│   ├── ControladorInicio.java
│   └── ControladorAsignatura.java
├── dao/
│   ├── IUsuarioCrud.java
│   └── IAsignaturaCrud.java
├── modelo/
│   ├── Usuario.java
│   └── Asignatura.java
├── servicio/
│   ├── IUsuarioServicio.java
│   ├── UsuarioServicioImp.java
│   ├── IAsignaturaServicio.java
│   └── AsignaturaServicioImp.java
└── AppApplication.java