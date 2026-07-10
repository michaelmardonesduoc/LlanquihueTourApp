package model;

public class ColaboradorExterno implements Registrable {

    private String nombre;
    private String servicio;   // ej: "Fotografía", "Catering"
    private String telefono;

    public ColaboradorExterno(String nombre, String servicio, String telefono) {
        this.nombre = nombre;
        this.servicio = servicio;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public String getServicio() { return servicio; }
    public String getTelefono() { return telefono; }

    @Override
    public String mostrarResumen() {
        return "Colaborador Externo: " + nombre +
                " | Servicio: " + servicio +
                " | Teléfono: " + telefono;
    }
}