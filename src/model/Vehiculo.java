package model;

public class Vehiculo implements Registrable {

    private String tipo;      // ej: "Van", "Bus", "Lancha"
    private String patente;
    private int capacidad;

    public Vehiculo(String tipo, String patente, int capacidad) {
        this.tipo = tipo;
        this.patente = patente;
        this.capacidad = capacidad;
    }

    public String getTipo() { return tipo; }
    public String getPatente() { return patente; }
    public int getCapacidad() { return capacidad; }

    @Override
    public String mostrarResumen() {
        return "Vehículo: " + tipo +
                " | Patente: " + patente +
                " | Capacidad: " + capacidad + " pasajeros";
    }
}
