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