package model;

/**
 * Representa un guía turístico de la agencia.
 *
 * Hereda de RecursoAgencia (id, nombre) y, por esa vía, cumple el contrato
 * de la interfaz Registrable definiendo su propio mostrarResumen().
 */
public class GuiaTuristico extends RecursoAgencia {

    // Atributos propios de esta subclase (los que la diferencian)
    private String idioma;
    private int aniosExperiencia;

    /**
     * Constructor: delega id y nombre a la superclase mediante super(...)
     * e inicializa los atributos específicos del guía.
     */
    public GuiaTuristico(String id, String nombre, String idioma, int aniosExperiencia) {
        super(id, nombre);              // llamada a la superclase RecursoAgencia
        this.idioma = idioma;
        this.aniosExperiencia = aniosExperiencia;
    }

    // ----- Getters propios (getId() y getNombre() se heredan) -----
    public String getIdioma() { return idioma; }
    public int getAniosExperiencia() { return aniosExperiencia; }

    public void setIdioma(String idioma) { this.idioma = idioma; }
    public void setAniosExperiencia(int aniosExperiencia) { this.aniosExperiencia = aniosExperiencia; }

    /**
     * Implementación polimórfica del contrato Registrable.
     * Reutiliza getDatosBase() heredado y agrega la información propia del guía.
     */
    @Override
    public String mostrarResumen() {
        return "Guia Turistico: " + getDatosBase() +
                " | Idioma: " + idioma +
                " | Experiencia: " + aniosExperiencia + " años";
    }
}