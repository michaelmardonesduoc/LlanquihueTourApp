# LlanquihueTourApp

Aplicación de gestión turística desarrollada en Java para el curso Desarrollo Orientado a Objetos - DUOC UC.

---

## Semana 6 - Herencia

### Objetivo
Implementar una jerarquía de clases usando herencia en Java, con una superclase abstracta y tres subclases que representan distintos tipos de servicios turísticos.

### Clases creadas

- `ServicioTuristico` — Superclase con atributos `nombre` y `duracionHoras`
- `RutaGastronomica` — Subclase con atributo `numeroDeParadas`
- `PaseoLacustre` — Subclase con atributo `tipoEmbarcacion`
- `ExcursionCultural` — Subclase con atributo `lugarHistorico`
- `GestorServicios` — Crea y almacena objetos de cada subclase
- `Main` — Muestra todos los servicios por consola

### Instrucciones para ejecutar Main

1. Abrir el proyecto en IntelliJ IDEA
2. Ejecutar la clase `ui/Main.java`
3. La consola mostrará los tours y los servicios turísticos registrados

---

## Semana 7 - Polimorfismo

### Objetivo
Aplicar polimorfismo sobre la jerarquía de `ServicioTuristico`, recorriendo
una colección genérica e invocando un método sobrescrito en cada subclase.

### Cambios realizados
- Se agregó el método `mostrarInformacion()` en la superclase `ServicioTuristico`.
- Cada subclase (`RutaGastronomica`, `PaseoLacustre`, `ExcursionCultural`) lo
  sobrescribe con `@Override`, mostrando su atributo específico.
- `GestorServicios.mostrarTodos()` recorre la colección `ArrayList<ServicioTuristico>`
  con un `for-each` e invoca `mostrarInformacion()` de forma polimórfica (sin `instanceof`).
- `Main` ejecuta `mostrarTodos()` para demostrar el comportamiento polimórfico.

### Ejecución
1. Abrir el proyecto en IntelliJ IDEA.
2. Ejecutar la clase `ui/Main.java`.
3. La consola mostrará los tours y luego los servicios turísticos, donde cada
   servicio imprime su información específica según su tipo.

---

## Semana 8 - Interfaces, Polimorfismo y Estructuras Dinámicas

### Descripción
Ampliación del sistema para gestionar nuevas entidades (guías, vehículos y
colaboradores externos) mediante una interfaz común, una colección genérica
y una interfaz gráfica de usuario.

### Interfaz y clases nuevas
- `Registrable` (interfaz) — contrato común con el método `mostrarResumen()`.
- `GuiaTuristico` — implementa Registrable (nombre, idioma, años de experiencia).
- `Vehiculo` — implementa Registrable (tipo, patente, capacidad).
- `ColaboradorExterno` — implementa Registrable (nombre, servicio, teléfono).
- `GestorEntidades` — colección `ArrayList<Registrable>` que recorre los objetos
  y usa `instanceof` para diferenciar cada tipo y generar un reporte con totales.
- `VentanaPrincipal` — interfaz gráfica (JFrame) para ingresar entidades y ver el reporte.

### Ejecución
1. Abrir el proyecto en IntelliJ IDEA.
2. Ejecutar la clase `ui/VentanaPrincipal.java`.
3. Usar los botones para agregar guías, vehículos y colaboradores.
4. Presionar "Ver Reporte" para visualizar el listado con la diferenciación por tipo.