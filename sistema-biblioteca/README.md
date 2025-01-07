# Sistema de Gestión de Biblioteca 📚

## Descripción General
Desarrollarás un sistema para administrar una biblioteca, permitiendo gestionar libros, préstamos, usuarios y categorías.

## Requerimientos Funcionales

### Gestión de Libros
- Crear, actualizar y eliminar libros
- Buscar libros por título, autor o ISBN
- Filtrar libros por categoría
- Ver disponibilidad de libros
- Registrar nuevas copias de libros existentes

### Gestión de Usuarios
- Registro de nuevos usuarios
- Actualización de datos de usuarios
- Consulta de historial de préstamos
- Sistema de roles (ADMIN, BIBLIOTECARIO, USUARIO)
- Gestión de estado de usuario (activo/inactivo)

### Gestión de Préstamos
- Registrar préstamos de libros
- Registrar devoluciones
- Generar multas por retrasos
- Consultar préstamos activos
- Envío de notificaciones de vencimiento

### Gestión de Categorías
- Crear y gestionar categorías de libros
- Asignar múltiples categorías a un libro
- Estadísticas por categoría

## Especificaciones Técnicas

### Arquitectura
- Arquitectura en capas (Controller, Service, Repository)
- Implementación de DTO's
- Manejo de excepciones personalizado
- Documentación con Swagger

### Base de Datos
- Uso de PostgreSQL
- Implementación de JPA/Hibernate
- Relaciones entre entidades:
    - OneToMany
    - ManyToMany
    - OneToOne

### Seguridad
- Implementación de Spring Security
- JWT para autenticación
- Control de acceso basado en roles
- Encriptación de contraseñas

### Estructura del Proyecto

```markdown
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── library/
│   │           ├── config/
│   │           ├── controller/
│   │           ├── dto/
│   │           ├── entity/
│   │           ├── exception/
│   │           ├── repository/
│   │           ├── security/
│   │           ├── service/
│   │           └── util/
│   └── resources/
│       └── application.properties
```

## Entidades Principales

### Libro (Book)
```java
- id: Long
- isbn: String
- título: String
- autor: String
- descripción: String
- copiesAvailable: Integer
- categories: List<Category>
```

### Usuario (User)
```java
- id: Long
- nombre: String
- email: String
- password: String
- role: Role
- status: UserStatus
```

### Préstamo (Loan)
```java
- id: Long
- user: User
- book: Book
- fechaPréstamo: LocalDateTime
- fechaVencimiento: LocalDateTime
- fechaDevolución: LocalDateTime
- status: LoanStatus
```

### Categoría (Category)
```java
- id: Long
- nombre: String
- descripción: String
```

## Requisitos Adicionales
1. Tests unitarios (JUnit y Mockito)
2. Tests de integración
3. Validaciones con Bean Validation
4. Paginación y ordenamiento en endpoints
5. Logs con SLF4J
6. Cache con Spring Cache
7. Manejo de transacciones
8. Implementación de eventos con Spring Events

## Ejercicios Integradores

1. **Configuración Inicial**
    - Configura el proyecto con Spring Boot
    - Implementa la estructura de carpetas
    - Configura la base de datos
    - Implementa Spring Security

2. **Gestión de Usuarios**
    - Implementa el registro y autenticación
    - Desarrolla el CRUD de usuarios
    - Implementa la gestión de roles

3. **Gestión de Libros**
    - Implementa el CRUD de libros
    - Desarrolla búsquedas y filtros
    - Implementa la gestión de copias

4. **Gestión de Préstamos**
    - Implementa el sistema de préstamos
    - Desarrolla la lógica de devoluciones
    - Implementa el sistema de multas

5. **Reportes y Estadísticas**
    - Implementa endpoints para estadísticas
    - Desarrolla reportes de préstamos
    - Implementa dashboard administrativo

## Bonus
- Implementación de tests E2E
- Dockerización del proyecto
- CI/CD con GitHub Actions
- Documentación detallada con OpenAPI
- Implementación de caché distribuida con Redis
