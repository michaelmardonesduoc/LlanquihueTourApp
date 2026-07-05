package model;

public class RutaGastronomica extends ServicioTuristico {

    private int numeroDeParadas;

    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas) {
        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }

    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Ruta Gastronómica | Paradas: " + numeroDeParadas;
    }
    // NUEVO (Semana 7): sobrescritura polimórfica
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("   Tipo: Ruta Gastronómica | Paradas: " + numeroDeParadas);
    }
}
