# Ejercicio 2
Ejercicio 2 - Nivel Intermedio:
Crea una aplicación de gestión de una biblioteca con relaciones entre entidades.

1. Crea las siguientes entidades:
    - `Biblioteca`:
        - id (Long)
        - nombre (String)
        - dirección (String)
        - teléfono (String)

    - `Libro` (Modifica la anterior):
        - id (Long)
        - título (String)
        - autor (String)
        - isbn (String)
        - año de publicación (Integer)
        - cantidad de copias (Integer)
        - biblioteca (Relación ManyToOne con Biblioteca)

2. Implementa:
    - Controladores REST para ambas entidades
    - Servicios para ambas entidades
    - Repositorios para ambas entidades

3. Los controladores deben tener:

   BibliotecaController:
    - Crear biblioteca (POST)
    - Obtener todas las bibliotecas (GET)
    - Obtener biblioteca por ID (GET)
    - Actualizar biblioteca (PUT)
    - Eliminar biblioteca (DELETE)
    - Obtener todos los libros de una biblioteca (GET)

   LibroController:
    - Crear libro en una biblioteca específica (POST)
    - Obtener todos los libros (GET)
    - Obtener libro por ID (GET)
    - Actualizar libro (PUT)
    - Eliminar libro (DELETE)
    - Buscar libros por autor (GET)
    - Buscar libros por título (GET)

4. Requisitos técnicos:
    - Usar Spring Boot
    - Base de datos H2
    - Implementar manejo de excepciones personalizado
    - Validaciones con Spring Validation
    - Documentación con Swagger/OpenAPI
    - Implementar DTOs para las respuestas

5. Validaciones requeridas:
    - El ISBN debe ser único
    - El título y autor no pueden estar vacíos
    - El año de publicación no puede ser futuro
    - La cantidad de copias debe ser mayor o igual a 0
    - El teléfono debe tener un formato válido

6. Manejo de excepciones para:
    - Recurso no encontrado
    - Violación de validaciones
    - ISBN duplicado
    - Biblioteca no existente al crear un libro

¿Te gustaría intentar este ejercicio? Si necesitas ayuda con alguna parte específica o quieres ver algún ejemplo de implementación, puedo ayudarte. También podemos revisar juntos el código cuando lo tengas listo.

Recuerda que este ejercicio es más complejo que el anterior y practica conceptos como:
- Relaciones entre entidades
- Validaciones
- Manejo de excepciones
- Documentación API
- DTOs
- Búsquedas personalizadas en repositorio

