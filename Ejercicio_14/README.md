# Ejercicio 1: Sistema de Gestión de Biblioteca 📚

## Objetivo
Crear una API RESTful para gestionar una biblioteca simple utilizando Spring Boot.

## Requisitos Funcionales

### Entidades Principales
1. Libro (Book)
    - ID (Long)
    - ISBN (String)
    - Título (String)
    - Autor (String)
    - Año de publicación (Integer)
    - Cantidad disponible (Integer)
    - Estado (Enum: DISPONIBLE, PRESTADO, EN_MANTENIMIENTO)

2. Usuario (User)
    - ID (Long)
    - Nombre (String)
    - Email (String)
    - Número de membresía (String)
    - Fecha de registro (LocalDateTime)

3. Préstamo (Loan)
    - ID (Long)
    - ID del libro (Long)
    - ID del usuario (Long)
    - Fecha de préstamo (LocalDateTime)
    - Fecha de devolución esperada (LocalDateTime)
    - Estado (Enum: ACTIVO, DEVUELTO, VENCIDO)

## Endpoints a Implementar

### Libros
- GET `/api/books` - Listar todos los libros
- GET `/api/books/{id}` - Obtener un libro por ID
- POST `/api/books` - Agregar un nuevo libro
- PUT `/api/books/{id}` - Actualizar información de un libro
- DELETE `/api/books/{id}` - Eliminar un libro

### Usuarios
- GET `/api/users` - Listar todos los usuarios
- GET `/api/users/{id}` - Obtener un usuario por ID
- POST `/api/users` - Registrar un nuevo usuario
- PUT `/api/users/{id}` - Actualizar información de usuario

### Préstamos
- POST `/api/loans` - Crear un nuevo préstamo
- PUT `/api/loans/{id}/return` - Registrar la devolución de un libro
- GET `/api/loans/user/{userId}` - Obtener todos los préstamos de un usuario

## Requisitos Técnicos

### Obligatorios
1. Usar Spring Boot 3.x
2. Implementar una base de datos H2 para desarrollo
3. Utilizar Spring Data JPA para la persistencia
4. Implementar manejo de excepciones personalizado
5. Validar los datos de entrada usando Spring Validation
6. Documentar la API usando SpringDoc OpenAPI

### Reglas de Negocio
1. Un usuario no puede tener más de 3 préstamos activos
2. Un libro no puede ser prestado si no hay copias disponibles
3. El período de préstamo es de 14 días
4. Implementar validaciones para evitar estados inválidos

## Puntos Extra (Opcionales)
1. Implementar paginación en los endpoints de listado
2. Agregar búsqueda de libros por título o autor
3. Implementar sistema de multas por retraso
4. Agregar tests unitarios
5. Implementar caché para las consultas frecuentes

## Estructura de Proyecto Sugerida
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── library/
│   │           ├── LibraryApplication.java
│   │           ├── controllers/
│   │           ├── models/
│   │           ├── repositories/
│   │           ├── services/
│   │           ├── exceptions/
│   │           └── dtos/
│   └── resources/
│       └── application.properties
└── test/
    └── java/
```

## Entregables Esperados
1. Código fuente en un repositorio Git
2. README con instrucciones de ejecución
3. Colección de Postman o curl commands para probar los endpoints
4. Documentación de la API (Swagger/OpenAPI)

¿Te gustaría empezar con este ejercicio? Una vez que lo completes o si tienes dudas específicas, podemos discutirlas y luego pasar al siguiente ejercicio.