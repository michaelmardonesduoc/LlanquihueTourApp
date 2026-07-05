package model;

public class ServicioTuristico {

    private String nombre;
    private int duracionHoras;

    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    // NUEVO (Semana 7): método base que las subclases sobrescribirán (polimorfismo)
    public void mostrarInformacion() {
        System.out.println("Servicio: " + nombre + " | Duración: " + duracionHoras + " horas");
    }

    @Override
    public String toString() {
        return "Servicio: " + nombre + " | Duración: " + duracionHoras + " horas";
    }
}