# App MVC Spring Boot - CRUD Usuarios y Asignaturas

Aplicacion web desarrollada con Spring Boot MVC, Thymeleaf, Spring Data JPA y MySQL.

El proyecto implementa operaciones CRUD para dos entidades principales:

- Usuarios
- Asignaturas

La aplicacion sigue una arquitectura MVC sencilla, separando responsabilidades en modelo, DAO, servicio, controlador y vistas.

## Tecnologias utilizadas

- Java 21
- Spring Boot 4.0.6
- Spring Web MVC
- Spring Data JPA
- Thymeleaf
- MySQL
- Lombok
- Spring Security
- Maven Wrapper
- CSS personalizado

## Estructura general del proyecto

```txt
src/main/java/com/asignatura/app/

controladores/
- ControladorInicio.java
- ControladorAsignatura.java

dao/
- IUsuarioCrud.java
- IAsignaturaCrud.java

modelo/
- Usuario.java
- Asignatura.java

servicio/
- IUsuarioServicio.java
- UsuarioServicioImp.java
- IAsignaturaServicio.java
- AsignaturaServicioImp.java

AppApplication.java
```

```txt
src/main/resources/

application.properties
messages.properties

templates/
- index.html
- modificar.html

templates/asignaturas/
- index.html
- modificar.html

templates/plantillas/
- partes.html

static/css/
- styles.css
```

## Entidades

### Usuario

La entidad `Usuario` esta mapeada a la tabla:

```txt
users
```

Campos principales:

- id
- cedula
- clave
- nombre
- email
- role
- status
- created_at
- updated_at

### Asignatura

La entidad `Asignatura` esta mapeada a la tabla:

```txt
asignatura
```

Campos principales:

- id
- nombre
- nombreCompleto
- descripcion
- areaConocimiento
- carrera
- numeroCreditos
- contenidoTematico
- semestre
- profesor

## Base de datos

La aplicacion esta configurada para conectarse a MySQL.

Configuracion actual:

```properties
spring.datasource.url=jdbc:mysql://localhost/crud_usuarios?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

La base de datos configurada es:

```txt
crud_usuarios
```

## Tabla asignatura

La tabla `asignatura` debe tener una estructura compatible con la entidad Java:

```sql
CREATE TABLE asignatura (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    nombreCompleto VARCHAR(200) NOT NULL,
    descripcion TEXT NULL,
    areaConocimiento VARCHAR(100) NULL,
    carrera VARCHAR(100) NULL,
    numeroCreditos INT NOT NULL,
    contenidoTematico TEXT NULL,
    semestre INT NULL,
    profesor VARCHAR(100) NULL
);
```

## Configuracion de Hibernate

El proyecto usa esta configuracion para respetar los nombres exactos de columnas en la base de datos:

```properties
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```

Esto es necesario porque algunas columnas de la tabla `asignatura` usan camelCase:

```txt
nombreCompleto
areaConocimiento
numeroCreditos
contenidoTematico
```

Sin esta configuracion, Hibernate podria intentar buscar columnas con snake_case, por ejemplo:

```txt
nombre_completo
area_conocimiento
numero_creditos
contenido_tematico
```

## Rutas principales

### Usuarios

Listado de usuarios:

```txt
GET /
```

Formulario para agregar usuario:

```txt
GET /agregar
```

Guardar usuario:

```txt
POST /guardar
```

Editar usuario:

```txt
GET /editar/{id}
```

Eliminar usuario:

```txt
GET /eliminar?id={id}
```

### Asignaturas

Listado de asignaturas:

```txt
GET /asignaturas
```

Formulario para agregar asignatura:

```txt
GET /asignaturas/agregar
```

Guardar asignatura:

```txt
POST /asignaturas/guardar
```

Editar asignatura:

```txt
GET /asignaturas/editar/{id}
```

Eliminar asignatura:

```txt
GET /asignaturas/eliminar?id={id}
```

## Vistas

### Usuarios

Listado de usuarios:

```txt
src/main/resources/templates/index.html
```

Formulario de usuarios:

```txt
src/main/resources/templates/modificar.html
```

### Asignaturas

Listado de asignaturas:

```txt
src/main/resources/templates/asignaturas/index.html
```

Formulario de asignaturas:

```txt
src/main/resources/templates/asignaturas/modificar.html
```

### Fragmentos comunes

Encabezado y pie de pagina:

```txt
src/main/resources/templates/plantillas/partes.html
```

## Estilos

Los estilos personalizados se encuentran en:

```txt
src/main/resources/static/css/styles.css
```

Las vistas cargan el archivo CSS con:

```html
<link rel="stylesheet" th:href="@{/css/styles.css}">
```

El archivo de estilos define:

- Fondos diferentes para cada vista
- Botones para acciones principales
- Tablas con bordes completos
- Formularios con mejor distribucion visual
- Colores suaves para mejorar la presentacion

## Mensajes de la aplicacion

Los textos usados por Thymeleaf se encuentran en:

```txt
src/main/resources/messages.properties
```

Alli se definen etiquetas para:

- Plantilla general
- Usuario
- Asignatura
- Acciones de formulario
- Validaciones

## Ejecucion del proyecto

### Windows

```bash
mvnw.cmd spring-boot:run
```

### Linux o macOS

```bash
./mvnw spring-boot:run
```

Luego abrir en el navegador:

```txt
http://localhost:9090
```

## Seguridad

El proyecto incluye Spring Security.

Si no existe una configuracion personalizada de usuarios, Spring Boot genera una contrasena temporal al iniciar la aplicacion.

En consola aparecera un mensaje similar a:

```txt
Using generated security password: xxxxxxxx
```

El usuario por defecto es:

```txt
user
```

## Funcionalidades

- Listar usuarios
- Crear usuarios
- Editar usuarios
- Eliminar usuarios
- Listar asignaturas
- Crear asignaturas
- Editar asignaturas
- Eliminar asignaturas
- Navegacion entre usuarios y asignaturas
- Estilos CSS personalizados
- Mensajes centralizados con `messages.properties`

## Arquitectura

El proyecto esta organizado en capas:

### Modelo

Contiene las entidades JPA que representan las tablas de la base de datos.

```txt
modelo/
```

### DAO

Contiene las interfaces que extienden `CrudRepository`.

```txt
dao/
```

### Servicio

Contiene las interfaces y clases de servicio que gestionan las operaciones de negocio.

```txt
servicio/
```

### Controladores

Contienen las rutas HTTP y conectan los servicios con las vistas Thymeleaf.

```txt
controladores/
```

### Vistas

Contienen las paginas HTML renderizadas con Thymeleaf.

```txt
templates/
```

## Autor

<p align="center">
  <img src="img/logo.png" width="250">
</p>

Desarrollado por Gary José Castaño Molina.