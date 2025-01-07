# EJERCICIO: Sistema de Gestión de Pokemon
#### API Base: https://pokeapi.co/api/v2/

### 1. Crear los siguientes modelos (estas son las estructuras base, deberás completarlas):

- Pokemon.java
    - public class Pokemon {
    - private Long id;
    - private String name;
    - private Integer height;
    - private Integer weight;
    - private List<PokemonType> types;
    - private Sprites sprites;
    - private List<Ability> abilities;
    - Agregar más campos según necesites
}

- PokemonType.java
  - public class PokemonType {
  - private Integer slot;
  - private Type type;
  }

  - Type.java
  - public class Type {
  - private String name;
  - private String url;
  }

- Sprites.java
  - public class Sprites {
  - private String frontDefault;
  - private String backDefault;
  - Agregar más campos según necesites
  }

- Ability.java
  - public class Ability {
  - private String name;
  - private String url;
  }

### Implementar los siguientes endpoints en tu API:


1. GET /api/pokemon
- Obtener lista de pokemon con paginación
- Permitir filtrar por tipo
- Implementar cache para mejorar rendimiento

2. GET /api/pokemon/{id}
- Obtener detalle de un pokemon específico
- Incluir sus tipos, habilidades y sprites

3. GET /api/pokemon/search
- Buscar pokemon por nombre
- Implementar búsqueda parcial

4. GET /api/pokemon/type/{type}
- Obtener todos los pokemon de un tipo específico

5. GET /api/pokemon/compare/{id1}/{id2}
- Comparar stats de dos pokemon
    */

### Requerimientos técnicos:

 - Usar Spring Boot 3.2 o superior
 - Implementar RestClient para consumo de API
 - Usar patrones DTO para las respuestas
 - Implementar manejo de excepciones
 - Documentar con OpenAPI/Swagger
 - Implementar tests unitarios
 - Usar caché para optimizar llamadas repetidas
 - Implementar rate limiting
 - Usar lombok para reducir boilerplate

### Bonus (opcional):
 - Implementar métricas con Micrometer
 - Agregar circuit breaker con Resilience4j
 - Implementar búsqueda avanzada con criterios múltiples
 - Crear un endpoint para equipos de pokemon
 - Agregar validaciones personalizadas