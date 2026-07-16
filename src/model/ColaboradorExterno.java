package model;

/**
 * Representa un colaborador externo que presta servicios a la agencia
 * (por ejemplo, un fotógrafo, un chef o un transportista independiente).
 *
 * Hereda de RecursoAgencia (id, nombre) y define su propia versión de
 * mostrarResumen(), cumpliendo el contrato de la interfaz Registrable.
 */
public class ColaboradorExterno extends RecursoAgencia {

    // Atributos propios de esta subclase
    private String empresa;
    private String servicio;        // ej: "Fotografia", "Catering", "Transporte"
    private double tarifaPorJornada;

    /**
     * Constructor: delega id y nombre a la superclase mediante super(...)
     * e inicializa los atributos específicos del colaborador.
     */
    public ColaboradorExterno(String id, String nombre, String empresa,
                              String servicio, double tarifaPorJornada) {
        super(id, nombre);              // llamada a la superclase RecursoAgencia
        this.empresa = empresa;
        this.servicio = servicio;
        this.tarifaPorJornada = tarifaPorJornada;
    }

    // ----- Getters y setters propios (getId() y getNombre() se heredan) -----
    public String getEmpresa() { return empresa; }
    public String getServicio() { return servicio; }
    public double getTarifaPorJornada() { return tarifaPorJornada; }

    public void setEmpresa(String empresa) { this.empresa = empresa; }
    public void setServicio(String servicio) { this.servicio = servicio; }
    public void setTarifaPorJornada(double tarifaPorJornada) { this.tarifaPorJornada = tarifaPorJornada; }

    /**
     * Implementación polimórfica del contrato Registrable.
     * Reutiliza getDatosBase() heredado y agrega la información propia del colaborador.
     */
    @Override
    public String mostrarResumen() {
        return "Colaborador Externo: " + getDatosBase() +
                " | Empresa: " + empresa +
                " | Servicio: " + servicio +
                " | Tarifa: $" + tarifaPorJornada + " por jornada";
    }
}