# Arquitectura del Sistema - Coworking App

## 1. Tipo de Aplicación
**Selección:** Aplicación Nativa (Android).

**Justificación:**
Se utiliza **Kotlin** y **Jetpack Compose** para aprovechar las librerías oficiales recomendadas por Google para el desarrollo moderno de aplicaciones móviles. Al ser nativa, se tiene acceso directo a las APIs del sistema y una optimización superior en el manejo de memoria y batería.

---

## 2. Patrón de Arquitectura
**Selección:** MVVM (Model-View-ViewModel).

**Justificación Técnica:**
*   **Desacoplamiento:** Separa la lógica de negocio de la interfaz de usuario, permitiendo que el código sea más fácil de testear y mantener.
*   **Manejo del Ciclo de Vida:** El ViewModel sobrevive a cambios de configuración (como la rotación de pantalla), evitando la pérdida de estado o recargas innecesarias de datos.
*   **Estado Reactivo:** Es el patrón ideal para trabajar con la naturaleza declarativa de Jetpack Compose, utilizando `StateFlow` o `Compose States` para que la UI se actualice automáticamente ante cualquier cambio en la fuente de datos.

---

## 3. Diagrama de Arquitectura
Ver la imagen de la carpeta architecture. 
---

## 4. Flujo General del Sistema
1.  **Inicio:** El usuario abre la aplicación y es recibido por la `View Layer` (Pantalla de Listado).
2.  **Carga de Datos:** El `ViewModel` solicita al `Repository` los espacios de coworking disponibles.
3.  **Procesamiento:** El `Repository` obtiene los datos y los entrega al `ViewModel`.
4.  **Actualización de UI:** El `ViewModel` actualiza el estado. La `View Layer`, que está observando este estado, se recompone automáticamente mostrando las tarjetas de los espacios.
5.  **Interacción:** Cuando el usuario selecciona un espacio, se dispara un evento hacia el `ViewModel` de navegación, el cual coordina el cambio hacia la Pantalla de Detalle.
