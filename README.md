# LlanquihueTourApp

## Nombre del proyecto
LlanquihueTourApp — Sistema de gestión de tours para la agencia de turismo Llanquihue Tour.

## Descripción del sistema
Aplicación de consola desarrollada en Java que gestiona los tours de la agencia Llanquihue Tour. El sistema lee los datos desde un archivo externo (.txt), los carga en una colección dinámica (ArrayList) y permite mostrarlos, filtrarlos (por stock disponible y por tipo) y buscarlos por nombre. Cada tour está asociado a un guía mediante una relación de composición, y la lectura del archivo incluye validaciones con try-catch para manejar datos incorrectos.

## Paquetes utilizados y clases implementadas
- **model**: clases del dominio.
    - `Tour`: representa un tour (nombre, tipo, stock y su guía). Contiene un objeto `Guia` (composición).
    - `Guia`: representa al guía de un tour (nombre e idioma).
- **data**: acceso a datos.
    - `GestorDatos`: lee el archivo, crea los objetos y los carga en un ArrayList, con manejo de errores mediante try-catch.
- **ui**: interfaz de usuario (consola).
    - `Main`: clase principal. Carga los tours y muestra los resultados por consola (todos, por stock, por tipo y búsqueda por nombre).

## Instrucciones para ejecutar el programa
1. Abre el proyecto en IntelliJ IDEA.
2. Verifica que exista el archivo `resources/tours.txt` con los datos.
3. Abre la clase principal `src/ui/Main.java`.
4. Ejecuta el método `main` (botón verde Run o Shift + F10).
5. Los resultados se mostrarán en la consola.

## Formato del archivo de datos (resources/tours.txt)
Separador: punto y coma ( ; ). Una línea por tour:
nombre;tipo;stock;nombreGuia;idioma

Ejemplo:
Isla Huar;gastronómico;15;María Soto;Inglés