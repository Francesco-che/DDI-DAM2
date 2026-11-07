# Gestión de Alquiler de Videojuegos (Java Swing & NetBeans)

Aplicación de escritorio desarrollada con **Java Swing** y **NetBeans** para gestionar de forma local (en memoria) usuarios, videojuegos, plataformas y alquileres, cumpliendo estrictamente con todas las reglas de negocio y requisitos de usabilidad del proyecto.

## 🚀 Características Principales

* **Ventana Principal con Tabla de Alquileres:** Muestra todos los alquileres activos y pasados ordenados de forma descendente por número de registro.
* **Marcaje Visual por Colores:**
  * 🟢 **Verde claro:** Alquileres devueltos correctamente.
  * 🔴 **Rojo claro:** Alquileres activos que han superado la fecha prevista de devolución (fuera de plazo).
* **Disponibilidad Dinámica por Plataforma:** Al registrar un alquiler, los botones de selección (RadioButtons) se habilitan o deshabilitan automáticamente según el stock real disponible para cada consola (PS5, Xbox, PC, Switch 2).
* **Validaciones con `ValidationAPI`:** Los nombres de usuario se validan estrictamente para garantizar que comiencen con letra mayúscula.
* **Integridad Referencial:** No se permite eliminar usuarios ni videojuegos si tienen alquileres activos asociados.
* **Interfaz Moderna:** Implementación de la librería **FlatLaf** para ofrecer un aspecto visual profesional, limpio y actualizado (compatible con modos claros y oscuros).

## 📊 Datos Iniciales Obligatorios

Al iniciar la aplicación, el sistema carga automáticamente los datos de prueba para comprobar de inmediato todas las funcionalidades:

1. **Usuarios iniciales:**
   * Marc Rosselló
   * Laura Martínez
2. **Videojuegos iniciales:**
   * **The Legend of Zelda:** Disponible para PS5 y Switch 2 (stock independiente).
   * **Cyberpunk 2077:** Disponible para Xbox y PC (stock independiente).
3. **Alquileres iniciales:**
   * Dos alquileres de ejemplo (uno por usuario) que reflejan el consumo de unidades y el estado visual (uno fuera de plazo y otro devuelto).

## 🛠️ Instrucciones de Ejecución

1. Clona o descarga este repositorio en tu máquina local.
2. Abre **NetBeans IDE**.
3. Selecciona **File > Open Project** y busca la carpeta del proyecto.
4. Asegúrate de que las dependencias (como *FlatLaf* en el archivo `pom.xml`) estén sincronizadas.
5. Haz clic derecho sobre el proyecto y selecciona **Clean and Build** para compilar correctamente los recursos y la estructura de paquetes.
6. Ejecuta la clase principal (**`MainScreen.java`**).

## 📂 Estructura del Proyecto

* `spdvi.model`: Clases de dominio (`Usuari`, `Joc`, `Lloguer`).
* `spdvi.view`: Interfaces gráficas de tipo `JFrame` y `JDialog` (`MainScreen`, `LloguerScreen`, `UsuariScreen`, `CrearJocScreen`, `TornarLloguerScreen`).
* `spdvi.controller`: Gestión de datos en memoria (`DataStore`).
* `spdvi.utils`: Validaciones centralizadas (`ValidationAPI`).
* `spdvi.resources`: Ficheros de recursos estáticos e iconos gráficos (`iconoMain.png`, etc.).