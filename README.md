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