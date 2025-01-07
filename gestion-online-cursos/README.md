# Sistema de Gestión de Cursos Online:

Requerimientos:
1. Gestionar dos entidades principales con una relación:
    - Curso
        - ID (generado automáticamente)
        - Nombre
        - Descripción
        - Duración (en horas)
        - Precio
        - Nivel (PRINCIPIANTE, INTERMEDIO, AVANZADO)
        - Estado (ACTIVO, INACTIVO)

    - Estudiante
        - ID (generado automáticamente)
        - Nombre
        - Email
        - Teléfono
        - Fecha de registro

2. Relación:
    - Un estudiante puede inscribirse en múltiples cursos
    - Un curso puede tener múltiples estudiantes
      (Relación Many-to-Many)

3. Funcionalidades:
    - CRUD completo para Cursos y Estudiantes
    - Endpoint para inscribir un estudiante en un curso
    - Endpoint para dar de baja un estudiante de un curso
    - Obtener todos los cursos de un estudiante
    - Obtener todos los estudiantes de un curso
    - Buscar cursos por nivel
    - Buscar cursos por rango de precio

4. Validaciones:
    - Email debe ser único y tener formato válido
    - Precio no puede ser negativo
    - Duración debe ser mayor a 0
    - No se puede inscribir un estudiante en un curso INACTIVO
    - No se puede inscribir el mismo estudiante dos veces en el mismo curso

Este ejercicio te ayudará a practicar:
- Relaciones entre entidades (Many-to-Many)
- Enumeraciones en Spring Boot
- Validaciones más complejas
- Consultas personalizadas
- Manejo de excepciones personalizado
- DTOs para las respuestas
