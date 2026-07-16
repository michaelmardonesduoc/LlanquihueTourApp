# LlanquihueTourApp

Sistema de gestión para la agencia de turismo **Llanquihue Tour**, desarrollado en Java como parte de la asignatura de Programación Orientada a Objetos (DUOC UC).

## Descripción del sistema actualizado

En esta etapa el sistema se amplió para gestionar nuevas entidades de la agencia (guías turísticos, vehículos y colaboradores externos) bajo un contrato de comportamiento común.

Las entidades se almacenan en una única colección genérica `ArrayList<Registrable>`, se recorren de forma polimórfica y se diferencian en tiempo de ejecución mediante el operador `instanceof`, aplicando lógica específica según el tipo real de cada objeto.

Además, se incorporó una interfaz gráfica básica construida con Swing (`JFrame` + `JOptionPane`) que permite el ingreso y la visualización de registros por parte del personal administrativo, sin necesidad de interactuar con la consola.

## Clases e interfaces utilizadas

### Paquete `model`
| Elemento | Tipo | Descripción |
|---|---|---|
| `Registrable` | Interfaz | Contrato común. Declara `mostrarResumen()` sin implementarlo. |
| `RecursoAgencia` | Clase abstracta | Superclase base. Centraliza `id` y `nombre`, implementa `Registrable` y deja `mostrarResumen()` abstracto. |
| `GuiaTuristico` | Subclase | Hereda de `RecursoAgencia`. Atributos propios: `idioma`, `aniosExperiencia`. |
| `Vehiculo` | Subclase | Hereda de `RecursoAgencia`. Atributos propios: `tipo`, `patente`, `capacidad`. |
| `ColaboradorExterno` | Subclase | Hereda de `RecursoAgencia`. Atributos propios: `empresa`, `servicio`, `tarifaPorJornada`. |

### Paquete `data`
| Elemento | Descripción |
|---|---|
| `GestorEntidades` | Administra la colección `ArrayList<Registrable>`. Recorre los objetos con `for-each`, invoca `mostrarResumen()` de forma polimórfica y aplica `instanceof` para generar información diferenciada por tipo. |

### Paquete `ui`
| Elemento | Descripción |
|---|---|
| `VentanaPrincipal` | Interfaz gráfica (`JFrame`) con botones de acción y área de reporte. Captura datos mediante `JOptionPane`. |
| `Main` | Clase principal. Punto de entrada del sistema. |

## Conceptos aplicados

- **Interfaces:** `Registrable` es implementada por la jerarquía completa (3 clases concretas).
- **Herencia:** una superclase (`RecursoAgencia`) con tres subclases diferenciadas.
- **Polimorfismo:** cada subclase sobrescribe `mostrarResumen()`; la llamada se resuelve en tiempo de ejecución.
- **Colecciones genéricas:** `ArrayList<Registrable>` almacena objetos de distintas clases.
- **Validación de tipos:** `instanceof` con downcast para aplicar lógica exclusiva de cada subclase.

## Instrucciones de ejecución

1. Clonar o descargar el repositorio.
2. Abrir el proyecto en **IntelliJ IDEA**.
3. Verificar que el JDK esté configurado (proyecto desarrollado con JDK 23).
4. Ejecutar la clase principal: Clic derecho sobre el archivo → **Run 'Main.main()'**.

5. Se abrirá la ventana **Llanquihue Tour - Gestión de Entidades**.

### Uso de la aplicación

| Botón | Acción |
|---|---|
| **Agregar Guía** | Solicita ID, nombre, idioma y años de experiencia. |
| **Agregar Vehículo** | Solicita ID, modelo, tipo, patente y capacidad. |
| **Agregar Colaborador** | Solicita ID, nombre, empresa, servicio y tarifa por jornada. |
| **Ver Reporte** | Muestra el reporte polimórfico con la lógica diferenciada por tipo. |

## Autor

**Michael Mardones**  
Analista Programador Computacional — DUOC UC