# ForoHub - Backend API Documentation

## Overview

ForoHub es una aplicación web de foro construida con Spring Boot, Spring Security, y JPA/Hibernate. Esta documentación proporciona detalles sobre la configuración del servidor, autenticación, seguridad, y cómo interactuar con la API.

## Tecnologías Utilizadas

- **Backend**: Java 17 o superior, Spring Boot 3.3.1, Spring Security, Spring Data JPA, H2 Database
- **Autenticación**: JWT (JSON Web Tokens)
- **Swagger**: Documentación de la API
- **Base de Datos**: H2 en memoria para desarrollo, MySQL o PostgreSQL para producción

## Configuración del Proyecto

### Dependencias

El proyecto utiliza Maven como sistema de gestión de dependencias. El archivo `pom.xml` contiene todas las dependencias necesarias para ejecutar el proyecto.

### Propiedades de la Aplicación

Las propiedades de la aplicación se encuentran en el archivo `application.properties`. Aquí se configuran aspectos como la conexión a la base de datos, la configuración de seguridad, y parámetros específicos de la aplicación como la clave secreta y la duración del token JWT.

## Seguridad

La seguridad de la aplicación está gestionada por Spring Security. Se utilizan filtros personalizados para la autenticación basada en tokens JWT. Los usuarios deben autenticarse mediante un endpoint `/login`, donde reciben un token JWT válido que debe ser incluido en el encabezado `Authorization` de las solicitudes subsiguientes.

## Endpoints de la API

### Usuarios

- **POST /login** - Autentica al usuario y devuelve un token JWT.
- **GET /usuarios** - Obtiene todos los usuarios.
- **POST /usuarios** - Crea un nuevo usuario.

### Cursos

- **GET /cursos** - Obtiene todos los cursos.
- **POST /cursos** - Crea un nuevo curso.

### Perfiles

- **GET /perfiles** - Obtiene todos los perfiles.
- **POST /perfiles** - Crea un nuevo perfil.

### Tópicos

- **GET /topicos** - Obtiene todos los tópicos.
- **POST /topicos** - Crea un nuevo tópico.
- **GET /topicos/{id}** - Obtiene un tópico por ID.
- **PUT /topicos/{id}** - Actualiza un tópico por ID.
- **DELETE /topicos/{id}** - Elimina un tópico por ID.

### Respuestas

- **GET /respuestas** - Obtiene todas las respuestas.
- **POST /respuestas** - Crea una nueva respuesta.

## Swagger UI

La documentación de la API se genera automáticamente utilizando Swagger. Puedes acceder a la interfaz de usuario de Swagger en `http://localhost:8080/swagger-ui.html`.

## Base de Datos

Se utiliza H2 en memoria para el entorno de desarrollo. Para el entorno de producción, se recomienda migrar a MySQL o PostgreSQL.

## Contribuciones

Contribuciones son bienvenidas. Por favor, abre un issue en GitHub si deseas contribuir.

## Contacto

Si tienes alguna pregunta o problema contacta en GitHub.
