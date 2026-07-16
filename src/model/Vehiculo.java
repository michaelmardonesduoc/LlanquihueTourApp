package model;

/**
 * Representa un vehículo de la flota de la agencia.
 *
 * Hereda de RecursoAgencia (id, nombre) y define su propia versión de
 * mostrarResumen(), cumpliendo el contrato de la interfaz Registrable.
 *
 * Nota: el atributo heredado "nombre" se usa aquí como el modelo del vehículo
 * (por ejemplo, "Mercedes Sprinter"), demostrando que un mismo atributo base
 * puede tener significado distinto según la subclase.
 */
public class Vehiculo extends RecursoAgencia {

    // Atributos propios de esta subclase
    private String tipo;        // ej: "Van", "Bus", "Lancha"
    private String patente;
    private int capacidad;

    /**
     * Constructor: delega id y nombre a la superclase mediante super(...)
     * e inicializa los atributos específicos del vehículo.
     */
    public Vehiculo(String id, String nombre, String tipo, String patente, int capacidad) {
        super(id, nombre);              // llamada a la superclase RecursoAgencia
        this.tipo = tipo;
        this.patente = patente;
        this.capacidad = capacidad;
    }

    // ----- Getters y setters propios (getId() y getNombre() se heredan) -----
    public String getTipo() { return tipo; }
    public String getPatente() { return patente; }
    public int getCapacidad() { return capacidad; }

    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setPatente(String patente) { this.patente = patente; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    /**
     * Implementación polimórfica del contrato Registrable.
     * Reutiliza getDatosBase() heredado y agrega la información propia del vehículo.
     */
    @Override
    public String mostrarResumen() {
        return "Vehiculo: " + getDatosBase() +
                " | Tipo: " + tipo +
                " | Patente: " + patente +
                " | Capacidad: " + capacidad + " pasajeros";
    }
}
