# Proyecto Final - Backend Java Sistema de Gestión Veterinaria
Requerimientos:

1. Entidades:
- Mascota (id, nombre, especie, raza, fecha_nacimiento, peso)
- Dueño (id, nombre, apellido, dni, teléfono, dirección, email)
- Veterinario (id, nombre, apellido, especialidad, número_licencia)
- Consulta (id, fecha, motivo, diagnóstico, tratamiento, próxima_visita)
- HistorialMédico (id, fecha, tipo_registro, descripción, medicamentos)
- Vacuna (id, nombre, fecha_aplicación, fecha_próxima)

2. Funcionalidades:
- Gestión completa de mascotas y dueños
- Agenda de citas médicas
- Registro de historial médico y vacunas
- Sistema de alertas para vacunaciones pendientes
- Facturación de servicios
- Gestión de inventario de medicamentos
- Reportes estadísticos mensuales

3. Requisitos Técnicos:
- Spring Security para autenticación
- JWT para manejo de sesiones
- PostgreSQL o MySQL
- Testing con JUnit y Mockito
- Documentación API con OpenAPI
- Logs con Log4j
- Manejo de archivos para fotos de mascotas
- Envío de emails para recordatorios
