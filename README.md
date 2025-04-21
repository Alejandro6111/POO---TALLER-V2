# 📂 Gestor de Arreglos en Java - POO + MVC

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![POO](https://img.shields.io/badge/Paradigma-POO-success)
![MVC](https://img.shields.io/badge/Patrón-MVC-important)

Aplicación Java para gestión de arreglos unidimensionales y bidimensionales con:
- 15+ operaciones por tipo de arreglo
- Interacción por consola
- Arquitectura MVC

## 🚀 Características principales

### 🔹 Para arreglos unidimensionales
✔️ Carga aleatoria/manual  
✔️ Operaciones matemáticas (suma, pares/impares)  
✔️ Búsqueda de máximo/mínimo  
✔️ Impresión formateada  

### 🔹 Para arreglos bidimensionales
✔️ Todas las operaciones adaptadas a matrices  
✔️ Suma por filas/columnas  
✔️ Búsqueda de extremos  

## 🛠️ Estructura del proyecto
📦 src  
 ┣ 📂 modelo  
 ┃ ┣ 📜 ArregloUnidimensional.java  
 ┃ ┗ 📜 ArregloBidimensional.java  
 ┣ 📂 vista  
 ┃ ┗ 📜 Consola.java  
 ┣ 📂 controlador  
 ┃ ┗ 📜 Controlador.java  
 ┗ 📜 Main.java

## 📦 Requisitos

- Java JDK 17+
- Git

## 🖥️ Cómo ejecutarlo

```bash
# 1. Clonar repositorio
git clone https://github.com/tu-usuario/POO---TALLER-V2.git
cd POO---TALLER-V2

# 2. Compilar (con Java estándar)
javac -d bin src/controller/*.java src/model/*.java src/view/*.java App.java

# 3. Ejecutar
java -cp bin App
```
## Diagrama de clases

![image](https://github.com/user-attachments/assets/d6944a5e-936c-4174-8249-9f0175b60fdb)

