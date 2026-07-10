package model;

public class GuiaTuristico implements Registrable {

    private String nombre;
    private String idioma;
    private int aniosExperiencia;

    public GuiaTuristico(String nombre, String idioma, int aniosExperiencia) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getNombre() { return nombre; }
    public String getIdioma() { return idioma; }
    public int getAniosExperiencia() { return aniosExperiencia; }

    @Override
    public String mostrarResumen() {
        return "Guía Turístico: " + nombre +
                " | Idioma: " + idioma +
                " | Experiencia: " + aniosExperiencia + " años";
    }
}