package model;

/**
 * Superclase base común para todas las entidades gestionables de la agencia.
 * Centraliza los atributos compartidos (id y nombre) y establece la jerarquía
 * sobre la que heredan GuiaTuristico, Vehiculo y ColaboradorExterno.
 *
 * Implementa Registrable pero deja mostrarResumen() abstracto: el contrato se
 * hereda, y cada subclase lo define a su manera (polimorfismo).
 */
public abstract class RecursoAgencia implements Registrable {

    // protected: accesibles directamente desde las subclases
    protected String id;
    protected String nombre;

    /**
     * Constructor común invocado por las subclases mediante super(...).
     */
    public RecursoAgencia(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // ----- Getters y setters heredados por todas las subclases -----
    public String getId() { return id; }
    public String getNombre() { return nombre; }

    public void setId(String id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Comportamiento común reutilizable: formato base de identificación.
     * Las subclases lo usan dentro de su propio mostrarResumen().
     */
    public String getDatosBase() {
        return "[" + id + "] " + nombre;
    }

    /**
     * Cada subclase está obligada a definir su propio resumen.
     */
    @Override
    public abstract String mostrarResumen();
}