# API Contracts

Se definen dos operaciones clave para el sistema de gestión de coworking, cumpliendo con el requisito de incluir al menos dos endpoints de tipo PUT o POST.

## 1. Listado de Endpoints

| Acción | Método | Ruta | Descripción |
| :--- | :--- | :--- | :--- |
| **Crear Reserva** | `POST` | `/api/reservations` | Registra una nueva reserva de un usuario en un espacio específico. |
| **Editar Espacio** | `PUT` | `/api/spaces/{id}` | Permite modificar los datos técnicos o de disponibilidad de un coworking existente. |

---

## 2. Definición de Contratos

### A. Crear Reserva (`POST /api/reservations`)

**Request Body:**
```json
{
  "spaceId": 1,
  "userId": 10,
  "hours": 2
}
```

**Response (201 Created):**
```json
{
  "id": 500,
  "status": "Confirmado"
}
```

---

### B. Editar Espacio (`PUT /api/spaces/{id}`)

**Request Body:**
```json
{
  "name": "Sala de Juntas Executive",
  "description": "Espacio premium con proyector y vista a la ciudad",
  "capacity": 10,
  "pricePerHour": 25.50,
  "isAvailable": true
}
```

**Response (200 OK):**
```json
{
  "message": "Espacio actualizado correctamente",
  "updatedAt": "2026-04-25T10:00:00Z"
}
```

---

## 3. Consideraciones Técnicas
*   **Formato:** Todas las peticiones y respuestas utilizan el estándar `application/json`.
*   **Códigos de Estado:** Se utilizan códigos HTTP estándar (201 para creaciones exitosas, 200 para actualizaciones y 400/404 para errores de validación o recursos no encontrados).
