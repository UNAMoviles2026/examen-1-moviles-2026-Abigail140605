# Diseño Backend (Conceptual) 

## 1. Arquitectura por Capas
El backend se organiza en tres capas principales para asegurar un código modular, mantenible y escalable:

*   **Capa de Presentación (Controllers):** Actúa como el punto de entrada al sistema. Se encarga de recibir las peticiones HTTP provenientes de la aplicación móvil y devolver las respuestas correspondientes en formato JSON.
*   **Capa de Negocio (Services):** Es el corazón del sistema donde se aplican todas las reglas de negocio (por ejemplo: validar la disponibilidad de un espacio o aplicar descuentos por horas).
*   **Capa de Datos (Repositories + Entities):** Es la responsable de la comunicación con la base de datos (SQL Server). Utiliza entidades para representar las tablas y repositorios para realizar consultas y persistencia de información.

---

## 2. Flujo de una Petición
El proceso de comunicación desde el cliente hasta la base de datos sigue este flujo:
1.  **Solicitud:** La aplicación móvil envía una solicitud HTTP al **Controller**.
2.  **Lógica:** El Controller delega la responsabilidad al **Service** correspondiente.
3.  **Persistencia:** El Service procesa la lógica y solicita al **Repository** los datos necesarios o el guardado de nueva información en la base de datos.
4.  **Transformación:** El resultado se transforma mediante **Mappers y DTOs** (Data Transfer Objects) para asegurar que solo se envíe la información estrictamente necesaria de vuelta al móvil, optimizando el ancho de banda.

---

## 3. Justificación Técnica
*   **Mappers y DTOs:** Se eligen para evitar la exposición directa de las entidades de la base de datos. 
*   **SQL Server:** Se selecciona como motor de base de datos por ser una solución robusta, confiable para el manejo de transacciones complejas y con excelente integridad de datos para el sistema de reservas.
